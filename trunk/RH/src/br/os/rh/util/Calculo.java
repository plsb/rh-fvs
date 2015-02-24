/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.util;

import br.os.rh.salariodiscplinas.SalarioDisciplina;
import java.util.List;

/**
 *
 * @author 'Pedro
 */
public class Calculo {

    public static double calculoSalarioMensalMensalista(List<SalarioDisciplina> disciplinas,
            int horasMensalista, double vHoraAula) {
        double horasMensaisMensalista = horasMensalista / 20;
        double totalMesMensalista = horasMensaisMensalista * 4;
        double horaAulaMesMensalista = totalMesMensalista / 0.75;
        return horaAulaMesMensalista * vHoraAula;
    }

    public static double calculoMensalistaHorista(List<SalarioDisciplina> disciplinas,
            int horasMensalista, double vHoraAula, double ajudaCusto,
            double porcentagemGrat) {
        int ch = calculoHorasSemestre(disciplinas);

        if (ch < horasMensalista) {
            ch = 0;
        } else {
            ch = ch - horasMensalista;
        }

        double horasMensais = (ch / 20) * 4.5;

        double remuneracaoMensal = horasMensais * vHoraAula;
        double umSexto = remuneracaoMensal / 6;

        double salarioBruto = remuneracaoMensal + umSexto + ajudaCusto;

        double valorMensalista = calculoSalarioMensalMensalista(disciplinas, horasMensalista, vHoraAula);

        double gratificacao = calculoGratificacaomensalista(porcentagemGrat, remuneracaoMensal, valorMensalista);

        return salarioBruto + valorMensalista + gratificacao;

    }

    public static double calculoGratificacaomensalista(double porc, double remuneracaoMensal, double valorMensalista) {
        return (porc * (remuneracaoMensal + valorMensalista)) / 100;
    }

    public static int calculoHorasSemestre(List<SalarioDisciplina> disciplinas, int... chMensalista) {
        int ch = 0;

//        for (int i = 0; i < disciplinas.size(); i++) {
//            ch += disciplinas.get(i).getDisciplina().getHoras();
//        }
        for (int i = 0; i < disciplinas.size(); i++) {
            for (int j = 0; j < disciplinas.get(i).getSdh().size(); j++) {
                ch += disciplinas.get(i).getSdh().get(j).getHorario().getQtdHora();
            }
        }
        
//        if (chMensalista != null) {
//            if (chMensalista.length > 0) {
//                ch -= chMensalista[0];
//            }
//        }

        return ch;
    }

    public static double calculoHorista(List<SalarioDisciplina> disciplinas,
            double vHoraAula, double ajudaCusto,
            double porcentagemGrat, int horasMensalista, double salarioMensalista, double comissao) {
        if (((calculoHorasSemestre(disciplinas)*20) - horasMensalista) > 0) {
//            double horasMensais = ((calculoHorasSemestre(disciplinas) - horasMensalista) / 20) * 4.5;
            double horasMensais = (((calculoHorasSemestre(disciplinas)*20) - horasMensalista)/20) * 4.5;
            double remuneracaoMensal = horasMensais * vHoraAula;
            double umSexto = remuneracaoMensal / 6;

            double gratificacao = calculoGratificacaoHorista(porcentagemGrat, remuneracaoMensal + salarioMensalista);

            double salarioBruto = remuneracaoMensal + umSexto + gratificacao + ajudaCusto;
            return salarioBruto + salarioMensalista + comissao;
        } else {
            return salarioMensalista + comissao;
        }
    }

    public static double calculoGratificacaoHorista(double porc, double remuneracaoMensal) {
        return (porc * remuneracaoMensal) / 100;
    }

}
