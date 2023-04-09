package maitre.API.entidade;

import java.util.Date;

public class Bar extends Estabelecimento {
    public Boolean isMaiorDeIdade(User u){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
        Date sysdate = new Date();

        if(u.getDtNasc().before(sysdate)){
            return true;
        }
        return false;
    }
}
