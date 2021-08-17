package Chain_Of_Responsibility_Design;


public class HR extends ILeaveRequestHandler{
	public HR(int days) {
		this.days=days;
	}
}
