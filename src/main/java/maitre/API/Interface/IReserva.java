package maitre.API.Interface;

import maitre.API.User;

public interface IReserva {
    public void checkIn(User u);

    public void checkOut(User u);
}
