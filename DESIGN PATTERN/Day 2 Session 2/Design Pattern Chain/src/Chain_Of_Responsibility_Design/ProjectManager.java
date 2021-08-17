package Chain_Of_Responsibility_Design;


public class ProjectManager extends ILeaveRequestHandler{
	
	public ProjectManager(int days) {
		this.days=days;
	}
}
