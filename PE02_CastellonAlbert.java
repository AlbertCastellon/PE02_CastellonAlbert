import java.util.Scanner;

public class PE02_CastellonAlbert {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        // Definim variables
        int gold = 50;
        String weapon, weaponCode, direction, spell;
        weapon = "res";
        weaponCode = "res";
        spell = "cap";
        boolean lookAround, buyPotion, potion, buyNecklace, necklace, knockDoor, alive;
        alive = true;
        necklace = false;
        potion = false;
        // Comencem la història
        System.out.println("Vas al mercat a comprar una arma, has d'explorar el bosc i pot ser perillós així podràs protegir-te.");
        System.out.println("Tens " + gold + " or per gastar.");
        // Primera elecció
        System.out.println("Vols mirar altres parades del mercat? (true/false)");
        lookAround = escaner.nextBoolean();
        if (lookAround) {
            // Camí alternatiu
            System.out.println("Pases per una parada que venen pocions per 10 or.");
            System.out.println("Vols comprar una poció? (true/false)");
            buyPotion = escaner.nextBoolean();
            if (buyPotion) {
                gold -= 10;
                System.out.println("Has comprat una poció. Et queden " + gold + " or.");
                potion = true;
            } else {
                System.out.println("No has comprat res");
            }
            System.out.println("Veus un penjoll amb forma de lluna que et crida l'atenció.");
            System.out.println("Vols comprar el penjoll per 10 or? (true/false)");
            buyNecklace = escaner.nextBoolean();
            if (buyNecklace) {
                gold -= 10;
                System.out.println("Has comprat el penjoll. Et queden " + gold + " or.");
                necklace = true;
            } else {
                System.out.println("No has comprat res");
            }
        }
        // Tornem al fil principal
        System.out.println("Arribes a la parada d'armes. Tens " + gold + " or per gastar.");
        System.out.println("Mires les armes disponibles.");
        // Oferim opcions d'armes
        System.out.println("1. Espasa llarga per 40 or (LS)");
        System.out.println("2. Espasa curta per 35 or (SS)");
        System.out.println("3. Daga per 20 or (D)");
        System.out.println("Quina arma vols comprar? (LS/SS/D)");
        
        weaponCode = escaner.next().toUpperCase();

        // Procés de compra amb estructura switch

        switch (weaponCode) {
            case "LS":
                if (gold >= 40) {
                    gold -= 40;
                    weapon = "Espasa llarga";
                    System.out.println("Has comprat una " + weapon + ". Et queden " + gold + " or.");
                } else {
                    System.out.println("No tens prou or per comprar aquesta arma.");
                    weaponCode = "res";
                }
                break;
            case "SS":
                if (gold >= 35) {
                    gold -= 35;
                    weapon = "Espasa curta";
                    System.out.println("Has comprat una " + weapon + ". Et queden " + gold + " or.");
                    if (necklace) {
                        // Possible fil per una elecció prèvia
                        System.out.println("El venedor et regala un escut.");
                        weapon = "Espasa curta i escut";
                        weaponCode = "SSS";
                    }
                } else {
                    System.out.println("No tens prou or per comprar aquesta arma.");
                    weaponCode = "res";

                }
                break;
            case "D":
                if (gold >= 20) {
                    gold -= 20;
                    weapon = "Daga";
                    System.out.println("Has comprat una " + weapon + ". Et queden " + gold + " or.");
                    if (necklace) {
                        // Possible fil per una elecció prèvia
                        System.out.println("El venedor et regala una altra daga.");
                        weapon = "2 dagues";
                        weaponCode = "DD";
                    }
                } else {
                    System.out.println("No tens prou or per comprar aquesta arma.");;
                }
                break;
            default:
                // Gestió d'errors en cas d'entrada no vàlida
                System.out.println("No has seleccionat una arma vàlida. El venedor et fa marxar per fer-li perdre el temps.");
                break;
        }
        // Continuem la història i aportem informació de l'estat del personatge
        System.out.println("Armat amb " + weapon + ", et dirigeixes cap al bosc.");
        if (potion) {
            System.out.println("Tens una poció per curar-te si et fan mal.");
        }
        System.out.println("Surts del poble i t'endinses al bosc. Què vols explorar, el nord o l'est?");
        // Elecció de direcció depenent de la qual es desenvolupa la història en diferents fils 
        direction = escaner.next().toLowerCase();
        if (!direction.equals("nord") && !direction.equals("est")) {
            // Gestió d'errors en cas d'entrada no vàlida
            System.out.println("T'has perdut i no saps tornar al poble. Acabes morint de gana.");
        } else if (direction.equals("nord")) {
            // Primer camí
            System.out.println("Mentre explores el bosc cap al nord, un llop t'ataca.");
            // Resolució del conflicte depenent de les armes i objectes que porta el personatge
            if(weaponCode.equals("SSS")) {
                System.out.println("Gràcies a l'escut que t'ha regalat el venedor, aconsegueixes matar el llop sense patir cap ferida.");
            }else if (weaponCode.equals("D")) {
                System.out.println("Només amb una daga mates el llop però acabes greument ferit.");
                if (potion) {
                    System.out.println("Per sort, tens una poció i aconsegueixes curar-te.");
                } else {
                    // Final del primer camí
                    System.out.println("Com no tens cap poció, acabes morint per les ferides.");
                    alive = false;
                }
            }else if (weaponCode.equals("res")) {
                // Final del primer camí
                System.out.println("Com estas desarmat, el llop et destrossa i acabes morint.");
                alive = false;
            } else {
                System.out.println("Ets ferit lleument però aconsegueixes matar el llop.");
                System.out.println("Envenes la ferida amb la roba que portes. I atures el sagnat.");
            }
            if(alive) {
                // Final del primer camí en cas de sobreviure
                System.out.println("Explores la zona i tornes al poble sa i estalvi.");
            }
        } else {
            // Segon camí
            System.out.println("Explorant el bosc cap a l'est, trobes una cabana.");
            System.err.println("Vols entrar sense trucar? (true/false)");
            knockDoor = escaner.nextBoolean();
            if (knockDoor) {  
                // Final del segon camí
                System.out.println("Al obrir la porta t'encega una llum i notes com et fas petit. El mag que viu a la cabana t'ha convertit en un gripau." );
            } else {
                System.out.println("Truques a la porta.");
                System.out.println("Un home d'avançada edat t'obre la porta i et convida a entrar.");
                if (!necklace) {
                    // Final del segon camí
                    System.out.println("L'home et serveix te i parleu una estona. Abans de marxar et comenta que sempre li ha agradat viure en tranquilitat però que des de que va morir la seva dona, se sent molt sol. Recorda a la seva dona i comenta que sempre portava un penjoll amb forma de lluna.");
                    System.out.println("Has explorat la part est del bosc i tornes al poble sa i estalvi.");
                } else {
                    System.out.println("L'home veu el penjoll que portes i et revela que es un mag i que et pot ensenyar un encanteri.");
                    if (weaponCode.equals("DD")) {
                        System.out.println("Com portes dues dagues, el mag t'ensenya l'encanteri per fer-te invisible.");
                        spell = "invisibilitat";
                    } else if (weaponCode.equals("SSS")) {
                        System.out.println("Com portes una espasa curta i un escut, el mag t'ensenya l'encanteri per fer-te invulnerable.");
                        spell = "invulnerabilitat";
                    } else if (weaponCode.equals("LS")) {
                        System.out.println("Com portes una espasa llarga, el mag t'ensenya l'encanteri per augmentar la teva força.");
                        spell = "superforça";
                    } else {
                        System.out.println("Com no portes cap arma, el mag t'ensenya l'encanteri per crear una arma de llum.");
                        spell = "arma de llum";
                    }
                    // Final del segon camí
                    System.out.println("Has explorat la part est del bosc i tornes al poble sa i estalvi.");
                    System.out.println("Ara saps l'encanteri " + spell + ".");
                }
            }
        }
        escaner.close();
    }
}