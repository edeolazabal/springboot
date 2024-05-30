package com.upc.empleadoapi.util;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.upc.empleadoapi.model.Empleado;
import com.upc.empleadoapi.service.EmpleadoService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// @Component("/listaEmpleados")
@Component
public class ListarEmpleadosPDF {

    private List<Empleado> empleados;


    public ListarEmpleadosPDF(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public  void writePDF() throws DocumentException, IOException  {

            Document document = new Document();

            try {
                DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
                String fechaActual = dateFormatter.format(new Date());
                System.out.println(fechaActual);

                String path = new File(".").getCanonicalPath();

                String FILE_NAME = path + "\\" +  "result_empleado_"+fechaActual+".pdf";
                //String FILE_NAME = path + "\\" + "result_empleado.pdf";
                System.out.println(FILE_NAME);

                PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

                document.open();

 //               List<Empleado> listadoEmpleados = empleadoService.list();

                Font f1 = new Font();
                f1.setFamily(com.itextpdf.text.Font.FontFamily.COURIER.name());
                f1.setStyle(Font.BOLD);
                f1.setSize(16);

                Font f2 = new Font();
                f2.setFamily(com.itextpdf.text.Font.FontFamily.COURIER.name());
                f2.setStyle(Font.NORMAL);
                f2.setSize(10);

                Paragraph titulo = new Paragraph("Listado de Empleados");
                titulo.setAlignment(Element.ALIGN_CENTER);
                titulo.setFont(f1);
                titulo.setSpacingAfter(10);
                document.add(titulo);

                Table tablaEmpleados = new Table(4);
                int[] colWidth = {1, 2, 2, 4};
                tablaEmpleados.setWidths(colWidth);
                tablaEmpleados.setPadding(5);

                tablaEmpleados.addCell("Id");
                tablaEmpleados.addCell("Nombre");
                tablaEmpleados.addCell("Apellido");
                tablaEmpleados.addCell("Email");


                empleados.forEach(emp -> {
                    tablaEmpleados.addCell(emp.getId().toString());
                    tablaEmpleados.addCell(emp.getNombre());
                    tablaEmpleados.addCell(emp.getApellido());
                    tablaEmpleados.addCell(emp.getEmail());
                  });

                document.add(tablaEmpleados);

                document.close();



            } catch (FileNotFoundException | DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
