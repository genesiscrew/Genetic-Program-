import java.util.*;
import org.jgap.*;
import org.jgap.gp.*;
import org.jgap.gp.function.*;
import org.jgap.gp.impl.*;
import org.jgap.gp.terminal.*;

public class FitnessFunction extends GPFitnessFunction {
	Float[] x;
	Float[] y;

	public FitnessFunction(Float[] x, Float[] y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}

	@Override
	protected double evaluate(IGPProgram arg0) {
		// TODO Auto-generated method stub
		return computeRawFitness(arg0);
	}

	private double computeRawFitness(IGPProgram arg0) {
		// TODO Auto-generated method stub
		double error = 0.0f;
		Object[] noargs = new Object[0];

		for (int i = 0; i < 20; i++) {

			try {

				double result = arg0.execute_float(0, noargs);

				error += Math.abs(result - y[i]);

				if (Double.isInfinite(error)) {
					return Double.MAX_VALUE;
				}

			}

			catch (ArithmeticException ex) {
				// This should not happen, some illegal operation was executed.
				// ------------------------------------------------------------
				System.out.println("x = " + x[i].floatValue());
				System.out.println(arg0);
				throw ex;
			}

		}

		if (error < 0.001) {
			error = 0.0d;
		}

		return error;
	}

}
