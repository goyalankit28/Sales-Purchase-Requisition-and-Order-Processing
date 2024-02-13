/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webtools.prprocessingapp.exception;

/**
 *
 * @author ankitgoyal
 */
public class UsersException extends Exception {

	public UsersException(String message)
	{
		super("UserException-"+message);
	}
	
	public UsersException(String message, Throwable cause)
	{
		super("UserException-"+message,cause);
	}
	
}
