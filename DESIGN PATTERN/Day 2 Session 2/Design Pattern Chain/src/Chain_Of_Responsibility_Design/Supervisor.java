package Chain_Of_Responsibility_Design;


public class Supervisor extends ILeaveRequestHandler{

	public Supervisor(int days) {
		this.days=days;
	}
}
