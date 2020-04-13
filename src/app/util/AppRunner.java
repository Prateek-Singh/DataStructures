package app.util;

import java.util.Scanner;

/**
 * Bootstraps the code to select a data structure in a loop and run it
 * 
 * @author Prateek Singh
 */
public class AppRunner {
    public static void run() throws Exception {        
        while(true) {
            System.out.println("Select the Id of the data structure to run or press 0 to exit");
            for(AppInstances appInstances : AppInstances.getList()) {
                System.out.println(String.format("%d : %s", appInstances.getId(), appInstances.getName()));
            }
            int id = new Scanner(System.in).nextInt();
            if (id == 0) {
                break;
            } else {
                Class dsToInstantiate = AppInstances.getClass(id);
                Runner run = (Runner) dsToInstantiate.newInstance();
                run.run();
            }
        }
    }
}