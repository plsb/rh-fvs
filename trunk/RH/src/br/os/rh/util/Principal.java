/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.util;

import br.os.rh.funcionario.Funcionario;
import br.os.rh.funcionario.FuncionarioDAO;
import br.os.rh.salario.Salario;
import br.os.rh.salario.SalarioDAO;
import static br.os.rh.util.Calculo.calculoHorasSemestre;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author 'Pedro
 */
public class Principal {

    public static void main(String[] args) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet1 = wb.createSheet("RH");

        SalarioDAO dao = new SalarioDAO();

        HSSFCellStyle estilo = wb.createCellStyle();
        //Adicionando bordas
        estilo.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        estilo.setBottomBorderColor(HSSFColor.BLACK.index);
        estilo.setBorderTop(HSSFCellStyle.BORDER_THIN);
        estilo.setTopBorderColor(HSSFColor.BLACK.index);
        estilo.setBorderRight(HSSFCellStyle.BORDER_THIN);
        estilo.setRightBorderColor(HSSFColor.BLACK.index);
        estilo.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        estilo.setLeftBorderColor(HSSFColor.BLACK.index);
        HSSFRow row = sheet1.createRow(0);
        row.createCell(0).setCellValue("Nome");
        row.createCell(1).setCellValue("Titulação");
        row.createCell(2).setCellValue("Curso");
        row.createCell(3).setCellValue("Cidade");
        row.createCell(4).setCellValue("Horas");
        row.createCell(5).setCellValue("Valor Hora Aula");
        row.createCell(6).setCellValue("Valor Horista");
        row.createCell(7).setCellValue("Valor Mensalista");
        row.createCell(8).setCellValue("1 Sexto");
        row.createCell(9).setCellValue("Gratificação");
        row.createCell(10).setCellValue("Ajuda de Custo");
        row.createCell(11).setCellValue("Total");
        row.createCell(12).setCellValue("Adiantamentos");
        row.createCell(13).setCellValue("Descontos");
        for (int j = 0; j < 14; j++) {
            row.getCell(j).setCellStyle(estilo);
        }
        double valorGeral = 0;

        for (int i = 0; i < dao.listar().size(); i++) {
            Salario s = dao.listar().get(i);
            if (s.isProfessor() && s.getFuncionario().isAtivo()) {
                row = sheet1.createRow(i);

                row.createCell(0).setCellValue(s.getFuncionario().getNome());
                row.createCell(1).setCellValue(s.getFuncionario().getTitulacao().getDescricao());
                row.createCell(2).setCellValue(s.getDisciplinas().get(0).getDisciplina().getSemestre().getCurso().getSigla());
                row.createCell(3).setCellValue(s.getFuncionario().getCidade().getDescricao());
                row.createCell(4).setCellValue((Calculo.calculoHorasSemestre(s.getDisciplinas()) / 20) * 4.5);
                row.createCell(5).setCellValue(s.getValHoraAula());
                if (s.getTipoRegime().equals("Mensalista/Horista")) {
                    double valorHorista = ((((Calculo.calculoHorasSemestre(s.getDisciplinas(), s.getHorasMensalista()) / 20) * 4.5)) * s.getValHoraAula());
                    row.createCell(6).setCellValue(valorHorista);
                    double valorMensalista = (Calculo.calculoSalarioMensalMensalista(s.getDisciplinas(), s.getHorasMensalista(),
                            s.getValHoraAula()));
                    row.createCell(7).setCellValue(valorMensalista);
                    row.createCell(8).setCellValue(valorHorista / 6);
                    row.createCell(9).setCellValue(Calculo.calculoGratificacaoHorista(s.getPorcentGratifica(), valorHorista + valorMensalista));
                    row.createCell(10).setCellValue(s.getValAjudaCusto());
                    double total = Calculo.calculoMensalistaHorista(s.getDisciplinas(), s.getHorasMensalista(), s.getValHoraAula(),
                            s.getValAjudaCusto(), s.getPorcentGratifica());
                    row.createCell(11).setCellValue(total);
                    valorGeral += total;
                } else {
                    double valorMensalHorista = ((Calculo.calculoHorasSemestre(s.getDisciplinas()) / 20) * 4.5) * s.getValHoraAula();
                    row.createCell(6).setCellValue(valorMensalHorista);
                    row.createCell(7).setCellValue("0");
                    double umSexto = valorMensalHorista / 6;
                    row.createCell(8).setCellValue(umSexto);
                    double gratificacao = Calculo.calculoGratificacaoHorista(s.getPorcentGratifica(), valorMensalHorista);
                    row.createCell(9).setCellValue(Calculo.calculoGratificacaoHorista(s.getPorcentGratifica(), valorMensalHorista));
                    row.createCell(10).setCellValue(s.getValAjudaCusto());
//                    double total = Calculo.calculoHorista(s.getDisciplinas(), s.getValHoraAula(),
//                            s.getValAjudaCusto(), s.getPorcentGratifica());
//                    row.createCell(11).setCellValue(total);
//                    valorGeral += total;
                }

//                row.createCell(12).setCellValue("adiantamentos");
//                row.createCell(13).setCellValue("desconto");
                for (int j = 0; j < 14; j++) {
                    row.getCell(j).setCellStyle(estilo);
                }

            }

        }

        row = sheet1.createRow(row.getRowNum() + 1);

        row.createCell(11).setCellValue(valorGeral);
//        row.createCell(11).setCellStyle(estilo);

        FileOutputStream stream = new FileOutputStream("C:\\Users\\'Pedro\\Documents\\NetBeansProjects\\rh-fvs\\RH\\osrh.xls");
        wb.write(stream);
    }

}
