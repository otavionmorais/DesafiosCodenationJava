package challenge;

public class CriptografiaCesariana implements Criptografia  {

    @Override
    public String criptografar(String texto) {
        //throw new UnsupportedOperationException("esse method nao esta implementado aainda");
        //a b c d e f g h i j k l m n o p q r s t u v w x y z
        if(texto==null)
            throw new NullPointerException("deveRetornarErroQuandoODesCriptografaTextoEhVazio");
        else if (texto.length()==0)
            throw new IllegalArgumentException("deveRetornarErroQuandoODesCriptografaTextoEhVazio");

        StringBuilder resp = new StringBuilder();
        texto=texto.toLowerCase();

        for(int i=0; i<texto.length(); i++){
            if( (texto.charAt(i)>='0' && texto.charAt(i)<='9') || texto.charAt(i)==' ' ){
                resp.append(texto.charAt(i));
            } else if( (texto.charAt(i)+3) <='z' ){
                resp.append( (char)(texto.charAt(i)+3));
            } else if( (texto.charAt(i)+3) >'z' ){
                resp.append( (char) ('a'+ 3 - ('z'-texto.charAt(i)))      );
            }
        }
        return resp.toString();
    }

    @Override
    public String descriptografar(String texto) {
        //a b c d e f g h i j k l m n o p q r s t u v w x y z
        if(texto==null)
            throw new NullPointerException("deveRetornarErroQuandoODesCriptografaTextoEhVazio");
        else if (texto.length()==0)
            throw new IllegalArgumentException("deveRetornarErroQuandoODesCriptografaTextoEhVazio");

        StringBuilder resp = new StringBuilder();
        texto=texto.toLowerCase();

        for(int i=0; i<texto.length(); i++){
            if( (texto.charAt(i)>='0' && texto.charAt(i)<='9') || texto.charAt(i)==' ' ){
                resp.append(texto.charAt(i));
            } else if( (texto.charAt(i)-3) >='a' ){
                resp.append( (char)(texto.charAt(i)-3));
            } else if( (texto.charAt(i)-3) <'a' ){
                resp.append( (char) ('z'- 3 + (texto.charAt(i)-'a'))      );
            }
        }
        return resp.toString();
    }
}
