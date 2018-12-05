package controller;

public interface RouterFactory {
	public Routable getRouter(String routerId) throws ControllerException;
}
