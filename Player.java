/*
	Tyler Whitaker
	CS 110
	Player class sets the players name.
*/

public class Player
{
   //Initialize variables
	String name;
   
	/**
      Constructor passes String name into the class and sets it to name variable
   */
	public Player(String n)
	{
		name = n;
	}
   
	/**
      getName method returns the players name
      @return name
   */
	public String getName()
	{
		return name;
	}
}