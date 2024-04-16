package calcularpotencia;

class Potencia {
    //Potencia positiva
    public double Power(int num, int pot){
        double res= num;
        if(pot == 0) return 1;
        else if(pot > 0){
            for(int i = 2 ; i<=pot; i++) res*=num;
            return res;
        }
        else{}
        return 0;
    }

    //Potencia negativa
    public double Powerneg(int num, int pot){
        double result=0;
        result=1/Power(num, pot * -1);
        return result;
    }
}
