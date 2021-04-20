package Lib;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.ChartData;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;

public class Report {

    public static void CreateWPExcel(String strPath, String strTitle, String strType) {


        int intWidth = 4;
        int intHeight = 25;
        int intSpace = 2;
        int intRowDescription = 2;
        int intMasterRow = intRowDescription + intSpace + 1;
        int intMasterColumn = intSpace - 1;

//        Get All File with specific extention
        File f = new File(strPath);
        if(f!=null){

            File[] matchingFiles = f.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith("png");
//                return name.startsWith("xxx") && name.endsWith("jpeg");
                }
            });
            Arrays.sort(matchingFiles);

            /*Create WP*/
            try {

                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet(strTitle);
                /*HEADER*/
                XSSFFont headerFont = (XSSFFont) wb.createFont();
                headerFont.setBold(true);
                headerFont.setUnderline(XSSFFont.U_SINGLE);
                headerFont.setFontHeightInPoints((short) 24);

                XSSFCellStyle styleHeader = (XSSFCellStyle) wb.createCellStyle();
                styleHeader.setFont(headerFont);

                XSSFCellStyle styleDescription = (XSSFCellStyle) wb.createCellStyle();
                styleDescription.setFillForegroundColor(IndexedColors.BLUE.getIndex());
                styleDescription.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                Cell cellHeader = sheet.createRow(0).createCell(0);
                cellHeader.setCellValue(strTitle);
                cellHeader.setCellStyle(styleHeader);
                /*HEADER*/


                int strCodeDefault = 0;

                for (int i = 0; i < matchingFiles.length; i++) {
                    String[] strCode = matchingFiles[i].getName().split("_");
                    int intCode = Integer.parseInt((strCode[0]).replaceAll("^0+",""));
                    if (intCode > strCodeDefault) {


                        if (strType.equalsIgnoreCase("HORIZONTAL")) {
                            Row rowDescription = sheet.createRow(intRowDescription);
                            Cell cellDescription = rowDescription.createCell(0);

                            for (int j = 0; j <= 500; j++)
                                rowDescription.createCell(j).setCellStyle(styleDescription);
                            cellDescription.setCellValue("Data ke-" + intCode);
//                        cellDescription.setCellValue(hasListDescription.get(intCode));
                            /*DESCRIPTION*/
                            if (intCode != 1) {
                                intMasterRow = intRowDescription + intSpace + 1;
                                intMasterColumn = intSpace - 1;
                            }

                            intRowDescription += (intSpace * 2) + 1 + intHeight;
                        } else if (strType.equalsIgnoreCase("VERTICAL")) {
                            /*DESCRIPTION*/


                            if (intCode != 1) {
                                wb.createSheet("WP-" + intCode);
                                sheet = wb.getSheetAt(intCode - 1);
                                cellHeader = sheet.createRow(0).createCell(0);
                                cellHeader.setCellValue(strTitle);
                                cellHeader.setCellStyle(styleHeader);

                                intMasterRow = intRowDescription + intSpace + 1;
                                intMasterColumn = intSpace - 1;
                            } else {
                                wb.setSheetName(intCode - 1, "WP-1");
                            }
                            Row rowDescription = sheet.createRow(intRowDescription);
                            Cell cellDescription = rowDescription.createCell(0);

                            for (int j = 0; j <= 500; j++)
                                rowDescription.createCell(j).setCellStyle(styleDescription);
                            cellDescription.setCellValue("Data ke-" + intCode);
//                        cellDescription.setCellValue(hasListDescription.get(intCode));

                        }
                        strCodeDefault = intCode;

                    }


                    InputStream inputStream = new FileInputStream(matchingFiles[i]);
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
                    inputStream.close();

                    CreationHelper helper = wb.getCreationHelper();
                    Drawing drawing = sheet.createDrawingPatriarch();
                    ClientAnchor anchor = helper.createClientAnchor();

                    //create an anchor with upper left cell _and_ bottom right cell
                    anchor.setCol1(intMasterColumn); //Column B
                    anchor.setRow1(intMasterRow); //Row 3
                    anchor.setCol2(intMasterColumn + intWidth); //Column C
                    anchor.setRow2(intMasterRow + intHeight); //Row 4
                    if (strType.equalsIgnoreCase("HORIZONTAL")) {
                        intMasterColumn += intWidth + intSpace;
                    } else {
                        intMasterRow += intHeight + intSpace;
                    }

                    //Creates a picture
                    drawing.createPicture(anchor, pictureIdx);
                }


                //Write the Excel file
                FileOutputStream fileOut = null;
                fileOut = new FileOutputStream(strPath + "WP-" + strTitle + ".xlsx");
                wb.write(fileOut);
                fileOut.close();
                System.out.println("Create WP");
            } catch (IOException ioex) {
                System.out.println("<><><><><><><><><><><><><><><><><>");
                System.out.println("Catch on create WP");
                System.out.println(ioex);
                System.out.println("<><><><><><><><><><><><><><><><><>");
            }


        }

    }

}
