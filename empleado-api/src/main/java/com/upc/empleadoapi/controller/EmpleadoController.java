package com.upc.empleadoapi.controller;


import com.upc.empleadoapi.model.Empleado;
import com.upc.empleadoapi.service.EmpleadoService;
import com.upc.empleadoapi.util.ListarEmpleadosPDF;
import com.upc.empleadoapi.util.ListarEmpleadosXLS;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    ListarEmpleadosPDF listarEmpleadosPDF;

    @GetMapping()
    public ResponseEntity<List<Empleado>> list() { return new ResponseEntity<List<Empleado>>(empleadoService.list(), HttpStatus.OK); }
    @PostMapping()
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado) { return new ResponseEntity<Empleado>(empleadoService.insert(empleado), HttpStatus.CREATED); }


        @GetMapping("/listarPdf")
        public ResponseEntity<String> listarPDF (HttpServletResponse response) throws IOException{
        //    public void listarPDF (HttpServletResponse response) throws IOException{

            response.setContentType("application/pdf");

            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
            String fechaActual = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=result_empleados_"+fechaActual+ ".pdf";
            response.setHeader(headerKey, headerValue);

            List<Empleado> empleados = empleadoService.list();

            ListarEmpleadosPDF listarEmpleadosPDF = new ListarEmpleadosPDF(empleados);

            listarEmpleadosPDF.writePDF();

            return new ResponseEntity<String>("Listado PDF", HttpStatus.OK);
        }

    @GetMapping("/listarXls")
    public ResponseEntity<String> exportToExcel(HttpServletResponse response) throws IOException {
    // public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        String fechaActual = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=result_empleados_"+fechaActual+".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Empleado> empleados = empleadoService.list();

        ListarEmpleadosXLS excelExporter = new ListarEmpleadosXLS(empleados);

        excelExporter.export(response);

        return new ResponseEntity<String>("Listado EXCEL", HttpStatus.OK);
    }


    }

