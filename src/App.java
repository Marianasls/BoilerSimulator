import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class App {
    public static void main(String[] args) throws Exception {
        // Carrega arquivo FCL
        String fileName = "fcl/simulator.fcl";
        FIS fis = FIS.load(fileName,true);

        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            System.exit(1);
        }

        FunctionBlock fb = fis.getFunctionBlock(null);

        // Define variaveis de entrada
        // fb.setVariable("temperature", 965);
        // fb.setVariable("volume", 11);
        // fb.setVariable("temperature", 920);
        // fb.setVariable("volume", 7.6);
        // fb.setVariable("temperature", 1050);
        // fb.setVariable("volume", 6.3);
        // fb.setVariable("temperature", 843);
        // fb.setVariable("volume", 8.6);
        fb.setVariable("temperature", 1122);
        fb.setVariable("volume", 5.2);

        // Retorna o valor
        fb.evaluate();

        // Exibe variáveis de saída
        fb.getVariable("pressure").defuzzify();

        // Imprime regras
        //System.out.println(fb);
		System.out.println("Pressure: " + fb.getVariable("pressure").getValue());
    }   
}

