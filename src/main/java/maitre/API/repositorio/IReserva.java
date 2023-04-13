package maitre.API.repositorio;

import maitre.API.entidade.Usuario;

public interface IReserva {
    public void checkIn(Usuario u);

    public void checkOut(Usuario u);
}
