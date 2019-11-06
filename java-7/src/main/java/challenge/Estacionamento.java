package challenge;

import java.util.ArrayList;
import java.util.List;

import static challenge.MensagensExceptions.NAO_HA_VAGA;

public class Estacionamento {

    List<Carro> estacionados = new ArrayList<>();

    public void estacionar(Carro carro) {

        if(carrosEstacionados()<10){

            estacionados.add(carro);

        } else {
            Motorista motoristaSelecionado=estacionados.get(0).getMotorista();

            if(motoristaSelecionado.getIdade()>55){

                boolean havaga=false;

                for(int i=1; i<estacionados.size(); i++){
                    motoristaSelecionado=estacionados.get(i).getMotorista();

                    if(motoristaSelecionado.getIdade()<=55) {
                        havaga=true;
                        estacionados.set(i, carro);
                        break;
                    }
                }

                if(!havaga)
                    throw new EstacionamentoException(NAO_HA_VAGA);

            } else {
                estacionados.set(0, carro);
            }
        }
    }

    public int carrosEstacionados() {
        return estacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return estacionados.contains(carro);
    }
}
