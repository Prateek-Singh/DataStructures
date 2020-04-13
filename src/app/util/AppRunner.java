package app.util;

import java.util.Optional;
import java.util.Scanner;

/**
 * Bootstraps the code to select a data structure in a loop and run it
 * 
 * @author Prateek Singh
 */
public class AppRunner {

    private AppRunner() {        
    }

    public static void run() {    
        try(Scanner scanner = new Scanner(System.in)) {
            while(true) {
                System.out.println("\nSelect the Id of the data structure to run or press 0 to exit\n");
                for(DSInstances dsInstances : DSInstances.getDSInstanceList()) {
                    System.out.println(String.format("%d : %s", dsInstances.getId(), dsInstances.getName()));
                }
                int id = scanner.nextInt();
                if (id == 0) {
                    break;
                } else {
                    Optional<DSInstances> optionalDsInstance = DSInstances.getDsInstanceById(id);
                    optionalDsInstance.ifPresent(dsinstance -> {
                        Runner runner = dsinstance.getDsInstance();
                        runner.run();
                    });
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } 
    }
}