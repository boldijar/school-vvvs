package evaluator;

import evaluator.exception.InputValidationFailedException;
import evaluator.model.Intrebare;
import org.junit.Assert;
import org.junit.Test;

public class StartAppTest {


    @Test
    public void configTC1ECP() {

        String enuntIntrebare = "Ce faci sambata seara?";
        String raspuns1 = "1) Bine fac";
        String raspuns2 = "2) Stau ";
        String raspuns3 = "3) Petrec cu fratii";
        String raspunsulCorect = "3";
        String domeniul = "Diverse";
        String errorMessage = "";

        try {
            new Intrebare(enuntIntrebare,raspuns1,raspuns2, raspuns3, raspunsulCorect,domeniul);
        } catch (InputValidationFailedException e) {
            Assert.assertEquals(errorMessage,e.getMessage());
        }
    }

    @Test
    public void configTC2ECP() {
        String enuntIntrebare = "iote ca nu e semn";
        String raspuns1 = "50";
        String raspuns2 = "25";
        String raspuns3 = "21";
        String raspunsulCorect = "1002";
        String domeniul = "4life";
        String errorMessage = "Prima litera din enunt nu e majuscula!";

        try {
            new Intrebare(enuntIntrebare,raspuns1,raspuns2, raspuns3, raspunsulCorect,domeniul);
        } catch (InputValidationFailedException e) {
            Assert.assertEquals(errorMessage,e.getMessage());
        }
    }

    @Test
    public void configTC3ECP() {
        String enuntIntrebare = "";
        String raspuns1 = "";
        String raspuns2 = "";
        String raspuns3 = "";
        String raspunsulCorect = "";
        String domeniul = "";
        String errorMessage = "Enuntul este vid!";

        try {
            new Intrebare(enuntIntrebare,raspuns1,raspuns2, raspuns3, raspunsulCorect,domeniul);
        } catch (InputValidationFailedException e) {
            Assert.assertEquals(errorMessage,e.getMessage());
        }
    }


    @Test
    public void configTC12ECP() {
        String enuntIntrebare = "Ce faci sambata seara?";
        String raspuns1 = "Bine fac";
        String raspuns2 = "2) Stau ";
        String raspuns3 = "3) Petrec cu fratii";
        String raspunsulCorect = "3";
        String domeniul = "Diverse";
        String errorMessage = "Varianta1 nu incepe cu '1)'!";

        try {
            new Intrebare(enuntIntrebare,raspuns1,raspuns2, raspuns3, raspunsulCorect,domeniul);
        } catch (InputValidationFailedException e) {
            Assert.assertEquals(errorMessage,e.getMessage());
        }
    }
    @Test
    public void configTC18ECP() {
        String enuntIntrebare = "Ce faci sambata seara?";
        String raspuns1 = "1) Bine fac";
        String raspuns2 = "Stau ";
        String raspuns3 = "3) Petrec cu fratii";
        String raspunsulCorect = "3";
        String domeniul = "Diverse";
        String errorMessage = "Varianta2 nu incepe cu '2)'!";

        try {
            new Intrebare(enuntIntrebare,raspuns1,raspuns2, raspuns3, raspunsulCorect,domeniul);
        } catch (InputValidationFailedException e) {
            Assert.assertEquals(errorMessage,e.getMessage());
        }
    }

    @Test
    public void configTC24ECP() {
        String enuntIntrebare = "Ce faci sambata seara?";
        String raspuns1 = "1) Bine fac";
        String raspuns2 = "2) Stau ";
        String raspuns3 = "Petrec cu fratii";
        String raspunsulCorect = "3";
        String domeniul = "Diverse";
        String errorMessage = "Varianta3 nu incepe cu '3)'!";

        try {
            new Intrebare(enuntIntrebare,raspuns1,raspuns2, raspuns3, raspunsulCorect,domeniul);
        } catch (InputValidationFailedException e) {
            Assert.assertEquals(errorMessage,e.getMessage());
        }
    }


    @Test
    public void configTC32ECP() {
        String enuntIntrebare = "Ce faci sambata seara?";
        String raspuns1 = "1) Bine fac";
        String raspuns2 = "2) Stau ";
        String raspuns3 = "3) Petrec cu fratii";
        String raspunsulCorect = "3";
        String domeniul = "diverse";
        String errorMessage = "Prima litera din domeniu nu e majuscula!";

        try {
            new Intrebare(enuntIntrebare,raspuns1,raspuns2, raspuns3, raspunsulCorect,domeniul);
        } catch (InputValidationFailedException e) {
            Assert.assertEquals(errorMessage,e.getMessage());
        }
    }

    @Test
    public void configTC3BVA() {
        String enuntIntrebare = "M";
        String raspuns1 = "1) a";
        String raspuns2 = "2) b";
        String raspuns3 = "3) c";
        String raspunsulCorect = "2";
        String domeniul = "Diverse";
        String errorMessage = "Ultimul caracter din enunt nu e '?'!";

        try {
            new Intrebare(enuntIntrebare,raspuns1,raspuns2, raspuns3, raspunsulCorect,domeniul);
        } catch (InputValidationFailedException e) {
            Assert.assertEquals(errorMessage,e.getMessage());
        }
    }

    @Test
    public void configTC4BVA() {
        StringBuilder enuntInt = new StringBuilder("M");
        for(int i=0; i<97; i++) {
            enuntInt.append(".");
        }
        enuntInt.append("?");
        String enuntIntrebare = enuntInt.toString();
        String raspuns1 = "1) a";
        String raspuns2 = "2) b";
        String raspuns3 = "3) c";
        String raspunsulCorect = "2";
        String domeniul = "Intrebari";
        String errorMessage = "";

        try {
            new Intrebare(enuntIntrebare,raspuns1,raspuns2,raspuns3, raspunsulCorect,domeniul);
        } catch (InputValidationFailedException e) {
            Assert.assertEquals(errorMessage,e.getMessage());
        }
    }

    @Test
    public void configTC5BVA() {
        StringBuilder enuntInt = new StringBuilder("M");
        for(int i=0; i<99; i++) {
            enuntInt.append(".");
        }
        enuntInt.append("?");
        String enuntIntrebare = enuntInt.toString();
        String raspuns1 = "1) a";
        String raspuns2 = "2) b";
        String raspuns3 = "3) c";
        String raspunsulCorect = "2";
        String domeniul = "Intrebari";
        String errorMessage = "Lungimea enuntului depaseste 100 de caractere!";

        try {
            new Intrebare(enuntIntrebare,raspuns1,raspuns2, raspuns3, raspunsulCorect,domeniul);
        } catch (InputValidationFailedException e) {
            Assert.assertEquals(errorMessage,e.getMessage());
        }
    }

}