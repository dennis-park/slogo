package backend.command.math;

import java.util.Random;

import backend.command.Command1Parameter;

public class RandomCommand extends Command1Parameter {
	
	@Override
	public double execute() {
		Random r = new Random();
		return r.nextDouble() * myArgument.execute();
	}

}
