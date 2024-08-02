import java.util.List;

public class AfficherMetriquesFlotte {
    private int robotsDisponibles;
    private int etatGeneral;
    private int utilisationGlobale;

    public AfficherMetriquesFlotte(int robotsDisponibles, int etatGeneral, int utilisationGlobale) {
        this.robotsDisponibles = robotsDisponibles;
        this.etatGeneral = etatGeneral;
        this.utilisationGlobale = utilisationGlobale;
    }

    public void afficherMetriques() {
        System.out.println("Robots disponibles: " + robotsDisponibles);
        System.out.println("État général: " + etatGeneral);
        System.out.println("Utilisation globale: " + utilisationGlobale);
    }

    public void afficherMetriques(List<Robot> robots) {
        for (Robot robot : robots) {
            afficherDetailsRobot(robot);
            System.out.println("-----------------------------------");
        }
    }

    private void afficherDetailsRobot(Robot robot) {
        System.out.println("Robot: " + robot.getNom());
        System.out.println("Niveau de batterie: " + robot.getNiveauBatterie());
        System.out.println("Consommation CPU: " + robot.getConsommationCPU());

    }

    // Getters et Setters
    public int getRobotsDisponibles() {
        return robotsDisponibles;
    }

    public void setRobotsDisponibles(int robotsDisponibles) {
        this.robotsDisponibles = robotsDisponibles;
    }

    public int getEtatGeneral() {
        return etatGeneral;
    }

    public void setEtatGeneral(int etatGeneral) {
        this.etatGeneral = etatGeneral;
    }

    public int getUtilisationGlobale() {
        return utilisationGlobale;
    }

    public void setUtilisationGlobale(int utilisationGlobale) {
        this.utilisationGlobale = utilisationGlobale;
    }
}
