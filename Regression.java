
import java.util.*;
import org.jgap.*;
import org.jgap.gp.*;
import org.jgap.gp.function.*;
import org.jgap.gp.impl.*;
import org.jgap.gp.terminal.*;

public class Regression extends GPProblem {

	public static Variable vx;

	public Regression(GPConfiguration a_conf) throws InvalidConfigurationException {
		super(a_conf);
	}

	@Override
	public GPGenotype create() throws InvalidConfigurationException {

		Class[] types = { CommandGene.FloatClass };
		Class[][] argTypes = { {} };

		// TODO Auto-generated method stub
		GPConfiguration a_conf = getGPConfiguration();

		CommandGene[][] nodeSets = {
			    {
			    vx = Variable.create(a_conf, "X", CommandGene.FloatClass),
			    new Add(a_conf, CommandGene.FloatClass),
			    new Subtract(a_conf, CommandGene.FloatClass),
			    new Multiply(a_conf, CommandGene.FloatClass),
			    new Divide(a_conf, CommandGene.FloatClass),
			    new Sine(a_conf, CommandGene.FloatClass),
			    new Cosine(a_conf, CommandGene.FloatClass),
			    new Exp(a_conf, CommandGene.FloatClass),
			    // Use terminal with possible value from 2.0 to 10.0 decimal
			    new Terminal(a_conf, CommandGene.FloatClass, 2.0d, 10.0d, false),
			    }
			  };
		return null;
	}

	public static void main(String[] args) throws Exception {
		  LoadData();
		  GPConfiguration config = new GPConfiguration();
		  config.setGPFitnessEvaluator(new DeltaGPFitnessEvaluator());
		  config.setMaxInitDepth(6);
		  config.setPopulationSize(100);
		  config.setFitnessFunction(new FitnessFunction());
	}

	private static void LoadData() {


	}

}
