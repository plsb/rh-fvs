package br.os.rh.util;

import java.util.concurrent.LinkedBlockingQueue;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.DPFPCapturePriority;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPDataListener;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import javax.swing.JOptionPane;

public class Biometria {

    public static Boolean compararDigitais(DPFPTemplate digitalPrevia,
            DPFPSample digitalAtual) {

        Boolean encontrou = false;

        try {
            DPFPFeatureExtraction featureExtractor = DPFPGlobal
                    .getFeatureExtractionFactory().createFeatureExtraction();
            DPFPFeatureSet featureSet = featureExtractor.createFeatureSet(
                    digitalAtual, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

            DPFPVerification matcher = DPFPGlobal.getVerificationFactory()
                    .createVerification();
            matcher.setFARRequested(DPFPVerification.MEDIUM_SECURITY_FAR);

            DPFPVerificationResult result = matcher.verify(featureSet,
                    digitalPrevia);

            encontrou = result.isVerified();
        } catch (Exception e) {
            System.out.printf("Erro!!! " + e.getMessage() + e.getCause());
        }

        return encontrou;
    }

    /* Classe do exemplo da DigitalPersona */
    public static DPFPSample getDigital() throws InterruptedException {
        final LinkedBlockingQueue<DPFPSample> samples = new LinkedBlockingQueue<DPFPSample>();
        DPFPCapture capture = DPFPGlobal.getCaptureFactory().createCapture();
        capture.setReaderSerialNumber(null);
        capture.setPriority(DPFPCapturePriority.CAPTURE_PRIORITY_LOW);
        capture.addDataListener(new DPFPDataListener() {
            public void dataAcquired(DPFPDataEvent e) {
                if (e != null && e.getSample() != null) {
                    try {
                        samples.put(e.getSample());
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        capture.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            int lastStatus = DPFPReaderStatusEvent.READER_CONNECTED;

            public void readerConnected(DPFPReaderStatusEvent e) {
                if (lastStatus != e.getReaderStatus()) {
                    System.out.println("Leitor conectado!");
                }
                lastStatus = e.getReaderStatus();
            }

            public void readerDisconnected(DPFPReaderStatusEvent e) {
                if (lastStatus != e.getReaderStatus()) {
                    JOptionPane.showMessageDialog(null, "O leitor esta desconectado!");
                }
                lastStatus = e.getReaderStatus();
            }

        });
        try {
            capture.startCapture();
            System.out
                    .print("Registre a digital do indicador da mao direita para verificacao.\n");
            return samples.take();
        } catch (RuntimeException e) {
            System.out
                    .printf("Falha ao iniciar captura. Verifique se o leitor n�o esta sendo usado por outra applica��o.\n");
            throw e;
        } finally {
            capture.stopCapture();
        }
    }

}
