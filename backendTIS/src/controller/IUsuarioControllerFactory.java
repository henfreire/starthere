package controller;

import controllerImpl.ControllerException;

public interface IUsuarioControllerFactory {
	public UsuarioController getController (String key) throws ControllerException;
}
