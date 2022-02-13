package com.example.pdfcreatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
    //Source: https://www.youtube.com/watch?v=nWbFXYN5EME
    //Part 2 of this video: https://youtu.be/lD7BvdJM7MY
    // Implemented by Mohamed Belhassen
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            createPDF();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }


    private void createPDF() throws FileNotFoundException{

        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdfPath,"myPdf.pdf");
        OutputStream outputStream= new FileOutputStream(file);

        PdfWriter writer= new PdfWriter(file);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        DeviceRgb invoiceGreen = new DeviceRgb(51,204,51);
        DeviceRgb invoiceGray = new DeviceRgb(220,220,220);

        float columnWidth[]={140,140,140,140};
        Table table1 = new Table(columnWidth);

        Image image1=getImageFromDrawableResource(R.drawable.logo,120);


        //Table 1----------01
        table1.setBorder(Border.NO_BORDER);
        table1.addCell(new Cell(4,1).add(image1));
        table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell(1,2).add(new Paragraph("Invoice")
                                                            .setFontSize(26f)
                                                            .setFontColor(invoiceGreen)));
        //table1.addCell(new Cell().add(new Paragraph("")));

        //Table 1----------02
        //table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph("Invoice No:")));
        table1.addCell(new Cell().add(new Paragraph("#2345678")));

        //Table 1----------03
        //table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph("Invoice Date:")));
        table1.addCell(new Cell().add(new Paragraph("10-03-2021")));

        //Table 1----------04
        //table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph("Account No:")));
        table1.addCell(new Cell().add(new Paragraph("223344")));

        //Table 1----------05
        table1.addCell(new Cell().add(new Paragraph("\n")));
        table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph("")));

        //Table 1----------06
        table1.addCell(new Cell().add(new Paragraph("To")));
        table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph("")));

        //Table 1----------07
        table1.addCell(new Cell().add(new Paragraph("Disha Verma")));
        table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph("Payment method:").setBold()));
        table1.addCell(new Cell().add(new Paragraph("")));

        //Table 1----------08
        table1.addCell(new Cell().add(new Paragraph("523 Andheri west")));
        table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell(1,2).add(new Paragraph("Paypal: payments@greenleaf.com")));
        //table1.addCell(new Cell().add(new Paragraph("")));

        //Table 1----------09
        table1.addCell(new Cell().add(new Paragraph("Mumbai")));
        table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell(1,2).add(new Paragraph("Card payment: We accept Visa, Mastercard")));
        //table1.addCell(new Cell().add(new Paragraph("")));

        float columnWidth2[]={62,162,112,112,112};
        Table table2 = new Table(columnWidth2);



        //table2----------01
        table2.addCell(new Cell().add(new Paragraph("S. No").setFontColor(ColorConstants.WHITE)).setBackgroundColor(invoiceGreen));
        table2.addCell(new Cell().add(new Paragraph("Item Description").setFontColor(ColorConstants.WHITE)).setBackgroundColor(invoiceGreen));
        table2.addCell(new Cell().add(new Paragraph("Rate").setFontColor(ColorConstants.WHITE)).setBackgroundColor(invoiceGreen));
        table2.addCell(new Cell().add(new Paragraph("Qty").setFontColor(ColorConstants.WHITE)).setBackgroundColor(invoiceGreen));
        table2.addCell(new Cell().add(new Paragraph("Price").setFontColor(ColorConstants.WHITE)).setBackgroundColor(invoiceGreen));

        //table2----------02
        table2.addCell(new Cell().add(new Paragraph("1.")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("Marigold seeds")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("50")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("2")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(invoiceGray));
        //table2----------03
        table2.addCell(new Cell().add(new Paragraph("2.")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("Furtilizer")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("300")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("1")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("300")).setBackgroundColor(invoiceGray));

        //table2----------04
        table2.addCell(new Cell().add(new Paragraph("3.")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("Tool")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("150")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("2")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("300")).setBackgroundColor(invoiceGray));

        //table2----------05
        table2.addCell(new Cell().add(new Paragraph("4.")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("Cactus Plant")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("400")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("1")).setBackgroundColor(invoiceGray));
        table2.addCell(new Cell().add(new Paragraph("400")).setBackgroundColor(invoiceGray));

        //table2----------06
        table2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("Sub-Total").setFontColor(ColorConstants.WHITE)).setBackgroundColor(invoiceGreen));
        table2.addCell(new Cell().add(new Paragraph("1100").setFontColor(ColorConstants.WHITE)).setBackgroundColor(invoiceGreen));

        //table2----------07
        table2.addCell(new Cell(1,2).add(new Paragraph("Terms and conditions:")).setBorder(Border.NO_BORDER));
        //table2.addCell(new Cell().add(new Paragraph("")));
        table2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("GST(12%)").setFontColor(ColorConstants.WHITE)).setBackgroundColor(invoiceGreen));
        table2.addCell(new Cell().add(new Paragraph("132").setFontColor(ColorConstants.WHITE)).setBackgroundColor(invoiceGreen));

        //table2----------08
        table2.addCell(new Cell(1,2).add(new Paragraph("Goods sold are not returnable and exchangeable.")).setBorder(Border.NO_BORDER));
        //table2.addCell(new Cell().add(new Paragraph("")));
        table2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("Grand Total").setBold().setFontSize(16).setFontColor(ColorConstants.WHITE)).setBackgroundColor(invoiceGreen));
        table2.addCell(new Cell().add(new Paragraph("1232").setBold().setFontSize(16).setFontColor(ColorConstants.WHITE)).setBackgroundColor(invoiceGreen));


        float columnWidth3[]={50,250,260};
        Table table3 = new Table(columnWidth3);

        Image image2=getImageFromDrawableResource(R.drawable.contact,120);
        Image image3=getImageFromDrawableResource(R.drawable.thankyou,120);
        image3.setHorizontalAlignment(HorizontalAlignment.RIGHT);



        table3.addCell(new Cell(3,1).add(image2).setBorder(Border.NO_BORDER));
        table3.addCell(new Cell().add(new Paragraph("yourEmail@gmail.com\n" +
                "yourEmail2@gmail.com")).setBorder(Border.NO_BORDER));
        table3.addCell(new Cell(3,1).add(image3).setBorder(Border.NO_BORDER));

        table3.addCell(new Cell().add(new Paragraph("+91-11234345677\n+91-11234345678")).setBorder(Border.NO_BORDER));
        table3.addCell(new Cell().add(new Paragraph("#153/A Mahraja Street\nGwalior, India")).setBorder(Border.NO_BORDER));

        //suite
        //Part 2 of this video: https://youtu.be/lD7BvdJM7MY

        document.add(table1);
        document.add(new Paragraph("\n"));
        document.add(table2);
        document.add(new Paragraph("\n\n\n\n\n\n(Authorized Signatory)\n\n\n").setTextAlignment(TextAlignment.RIGHT));
        document.add(table3);

        document.close();
        Toast.makeText(this,"Pdf created", Toast.LENGTH_LONG).show();
    }

    Image getImageFromDrawableResource(int drawableResourceId, int imageHeight){
        Drawable d = getDrawable(drawableResourceId);
        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] bitmapData= stream.toByteArray();
        ImageData imageData= ImageDataFactory.create(bitmapData);
        Image image= new Image(imageData);
        image.setHeight(imageHeight);
        image.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        return image;
    }

}