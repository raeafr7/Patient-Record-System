//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Patient Record System
// Files: PatientRecord, PatientRecordNode, PatientRecordTree, PatientRecordTreeTester
// Course: 300, 2nd term, 2020
//
// Author: Raea Freund
// Email: rfreund2@wisc.edu
// Lecturer's Name: Gary Dahl
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * PatientRecordTree.
 *
 */

public class PatientRecordTreeTester {

    // START add, size, toString testing scenarios

    /**
     * passes in a new empty PatientRecordTree, checks that its size is 0, it is empty,
     * and that its string representation is an empty string "".
     * @param binary tree to test
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testAddToStringSize1(PatientRecordTree bst) {
        if (bst.size() != 0) {
            System.out.println("Size should have been 0 for a tree with no nodes but it was not!");
            return false;
        }
        if (!bst.isEmpty()) {
            System.out.println(
                "isEmpty() should have returned true for a tree with no nodes but it did not!");
            return false;
        }
        if (!bst.toString().equals("")) {
            System.out.println(
                "toString() should return an empty string for a tree with no nodes but it did not!");
            System.out.println("Contents of tree: " + bst.toString());
            return false;
        }
        return true;
    }

    /**
     * tries adding one patient record, checks that the addPatientRecord() method call 
     * returns true, the tree is not empty, its size is 1, and the .toString() called
     * on the tree returns the expected output.
     * @param binary tree to test
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testAddToStringSize2(PatientRecordTree bst) {
        if (!bst.addPatientRecord(new PatientRecord("Norah", "11/23/1985"))) {
            System.out.println("Could not successfully add first patient! Check method.");
            return false;
        }
        if (bst.size() != 1) {
            System.out.println(
                "The size of the tree should have been 1 after adding a single patient, but it was not.");
            return false;
        }
        if (bst.isEmpty()) {
            System.out
                .println("The tree should not be empty after adding a single patient but it was!");
            return false;
        }
        if (!bst.toString().equals("Norah(11/23/1985)\n")) {
            System.out.println(
                "toString printed unexpected output after adding a single patient. Check method.");
            System.out.println("Contents of tree: " + bst.toString());
            return false;
        }
        return true;
    }

    /**
     * tries adding another patientRecord which is older that the one at the root.
     * @param binary tree to test
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testAddToStringSize3(PatientRecordTree bst) {
        if (!bst.addPatientRecord(new PatientRecord("George", "5/27/1943"))) {
            System.out.println("Could not successfully add an older patient than "
                + "the one at root. Check method.");
            return false;
        }
        if (bst.size() != 2) {
            System.out.println("The size of the tree should have been 2 after "
                + "adding another older patient but it was not!");
            return false;
        }
        if (!bst.toString().equals("George(5/27/1943)\nNorah(11/23/1985)\n")) {
            System.out.println(
                "toString printed unexpected output after adding an older patient. Check method.");
            System.out.println("Contents of tree: " + bst.toString());
            return false;
        }
        if (bst.isEmpty()) {
            System.out.println("tree should not have been empty.");
            return false;
        }
        return true;
    }

    /**
     * tries adding a third patientRecord which is younger than the one at the root.
     * @param binary tree to test
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testAddToStringSize4(PatientRecordTree bst) {
        if (!bst.addPatientRecord(new PatientRecord("William", "6/4/1998"))) {
            System.out.println("Could not successfully add a younger patient than "
                + "the one at root. Check method.");
            return false;
        }
        if (bst.size() != 3) {
            System.out.println("The size of the tree should have been 3 after "
                + "adding another younger patient but it was not!");
            return false;
        }
        if (!bst.toString().equals("George(5/27/1943)\nNorah(11/23/1985)\nWilliam(6/4/1998)\n")) {
            System.out.println(
                "toString printed unexpected output after adding a younger patient. Check method.");
            System.out.println("Contents of tree: " + bst.toString());
            return false;
        }
        if (bst.isEmpty()) {
            System.out.println("tree should not have been empty.");
            return false;
        }
        return true;
    }

    /**
     * tries adding at least two further patientRecords such that one must be added
     * at the left subtree, and the other at the right subtree.
     * @param binary tree to test
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testAddToStringSize5(PatientRecordTree bst) {
        if (!bst.addPatientRecord(new PatientRecord("Adam", "8/12/1972"))) {
            System.out.println("Could not successfully add patient to left subtree. Check method.");
            return false;
        }
        if (!bst.addPatientRecord(new PatientRecord("Andrew", "4/20/2019"))) {
            System.out
                .println("Could not successfully add patient to right subtree. Check method.");
            return false;
        }
        if (bst.size() != 5) {
            System.out.println("The size of the tree should have been 5 after "
                + "adding 2 more patients but it was not!");
            return false;
        }
        if (!bst.toString().equals("George(5/27/1943)\nAdam(8/12/1972)\nNorah(11/23/1985)"
            + "\nWilliam(6/4/1998)\nAndrew(4/20/2019)\n")) {
            System.out.println("toString printed unexpected output after adding 2 more patients.");
            System.out.println("Contents of tree: " + bst.toString());
            return false;
        }
        return true;
    }

    /**
     * tries adding a patient whose date of birth was used as a key for a patient
     * record already stored in the tree. addPatientRecord() method call should return false,
     * and the size of the tree should not change.
     * @param binary tree to test
     * @return true indicating correct functionality and false otherwise.
     */
    public static boolean testAddToStringSize6(PatientRecordTree bst) {
        if (bst.addPatientRecord(new PatientRecord("Julissa", "8/12/1972"))) {
            System.out.println("A patient with this birth date already exists. "
                + "Add method should have returned false but it did not!");
            return false;
        }
        if (bst.size() != 5) {
            System.out.println("The size of the tree should not have changed after "
                + "failing to add a patient, but it did!");
            return false;
        }
        return true;
    }

    /**
     * Checks the correctness of the implementation of both addPatientRecord() and toString() methods
     * implemented in the PatientRecordTree class. This unit test considers at least the following
     * scenarios. (1) Create a new empty PatientRecordTree, and check that its size is 0, it is empty,
     * and that its string representation is an empty string "". (2) try adding one patient record and
     * then check that the addPatientRecord() method call returns true, the tree is not empty, its
     * size is 1, and the .toString() called on the tree returns the expected output. (3) Try adding
     * another patientRecord which is older that the one at the root, (4) Try adding a third patient
     * Record which is younger than the one at the root, (5) Try adding at least two further patient
     * records such that one must be added at the left subtree, and the other at the right subtree.
     * For all the above scenarios, and more, double check each time that size() method returns the
     * expected value, the add method call returns true, and that the .toString() method returns the
     * expected string representation of the contents of the binary search tree in an ascendant order
     * from the oldest patient to the youngest one. (6) Try adding a patient whose date of birth was
     * used as a key for a patient record already stored in the tree. Make sure that the
     * addPatientRecord() method call returned false, and that the size of the tree did not change.
     * 
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testAddPatientRecordToStringSize() {
        PatientRecordTree bst = new PatientRecordTree();
        Boolean pass1 = testAddToStringSize1(bst);
        Boolean pass2 = testAddToStringSize2(bst);
        Boolean pass3 = testAddToStringSize3(bst);
        Boolean pass4 = testAddToStringSize4(bst);
        Boolean pass5 = testAddToStringSize5(bst);
        Boolean pass6 = testAddToStringSize6(bst);
        if (pass1 && pass2 && pass3 && pass4 && pass5 && pass6) {
            return true;
        }
        System.out.println("One of your test cases failed!");
        return false;
    }

    // END add, size, toString testing scenarios

    // START lookup testing scenarios

    /**
     * check that the lookup() method with any valid date for an empty tree throws a NoSuchElementException.
     * @param tree to search
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testlookup1(PatientRecordTree bst) {
        try {
            bst.lookup("1/2/2000");
            System.out.println(
                "lookup method should have thrown an exception when searching an empty tree, but it did not.");
            return false;
        } catch (NoSuchElementException e) {
            return true;
        } catch (Exception e1) {
            System.out.println(
                "lookup method threw an unexpected exception when searching an empty tree!");
            System.out.println(e1.getMessage());
            return false;
        }
    }

    /**
     * calls lookup() method to search for patient at root and a patient at the right 
     * and left subtrees at different levels. 
     * @param bst tree to search of height 3 and size 5
     * @return true indicating correct functionality and false otherwise.
     */
    public static boolean testlookup2(PatientRecordTree bst) {
        // add 5 patients
        bst.addPatientRecord(new PatientRecord("A", "1/1/1985"));
        bst.addPatientRecord(new PatientRecord("B", "1/1/1943"));
        bst.addPatientRecord(new PatientRecord("C", "1/1/1998"));
        bst.addPatientRecord(new PatientRecord("D", "1/1/1972"));
        bst.addPatientRecord(new PatientRecord("E", "1/1/2019"));
        try {
            bst.lookup("1/1/1985");
            bst.lookup("1/1/1943");
            bst.lookup("1/1/1998");
            bst.lookup("1/1/1972");
            bst.lookup("1/1/2019");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("lookup method incorrectly threw a NoSuchElementException"
                + " when searching a tree containing patients at different levels.");
            return false;
        } catch (Exception e1) {
            System.out.println("lookup method incorrectly threw an unknown exception.");
            System.out.println(e1.getMessage());
            return false;
        }
    }

    /**
     * calls lookup() method on non-empty PatientRecordTree with date of birth not stored in the tree
     * @param bst tree to search
     * @return true indicating correct functionality and false otherwise.
     */
    public static boolean testlookup3(PatientRecordTree bst) {
        try {
            bst.lookup("1/1/1920");
            System.out.println("lookup should have thrown a NoSuchElement when searching"
                + " for a patient not currently in the tree, but it did not.");
            return false;
        } catch (NoSuchElementException e) {
            return true;
        } catch (Exception e1) {
            System.out.println("lookup threw an unknown exception when searching "
                + "for a patient not currently in the tree.");
            System.out.println(e1.getMessage());
            return false;
        }
    }

    /**
     * This method checks mainly for the correctness of the PatientRecordTree.lookup() method. It must
     * consider at least the following test scenarios. (1) Create a new PatientRecordTree. Then, check
     * that calling the lookup() method with any valid date must throw a NoSuchElementException. (2)
     * Consider a PatientRecordTree of height 3 which consists of at least 5 PatientRecordNodes. Then,
     * try to call lookup() method to search for the patient record at the root of the tree, then a
     * patient records at the right and left subtrees at different levels. Make sure that the lookup()
     * method returns the expected output for every method call. (3) Consider calling .lookup() method
     * on a non-empty PatientRecordTree with a date of birth not stored in the tree, and ensure that
     * the method call throws a NoSuchElementException.
     * 
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testAddPatientRecordAndLookup() {
        PatientRecordTree bst = new PatientRecordTree();
        boolean pass1 = testlookup1(bst);
        boolean pass2 = testlookup2(bst);
        boolean pass3 = testlookup3(bst);
        if (pass1 && pass2 && pass3) {
            return true;
        }
        System.out.println("One of your test cases failed!");
        return false;
    }

    // END lookup testing scenarios

    // START height testing scenarios

    /**
     * ensures that the height of an empty patient record tree is zero.
     * @param bst
     * @return true indicating correct functionality and false otherwise
     */
    public static boolean testHeight1(PatientRecordTree bst) {
        if (bst.height() != 0) {
            System.out.println("height of empty tree should have been 0 but it was not!");
            return false;
        }
        return true;
    }

    /**
     * ensures that the height of a tree which consists of only one node is 1.
     * @param bst
     * @return true indicating correct functionality and false otherwise
     */
    public static boolean testHeight2(PatientRecordTree bst) {
        bst.addPatientRecord(new PatientRecord("A", "1/1/1985"));
        if (bst.height() != 1) {
            System.out.println("height of tree with 1 node should have been 1 but it was not!");
            return false;
        }
        return true;
    }

    /**
     * ensures that the height of a tree with height 4 returns 4. 
     * @param bst
     * @return true indicating correct functionality and false otherwise
     */
    public static boolean testHeight3(PatientRecordTree bst) {
        // add 7 patients
        bst.addPatientRecord(new PatientRecord("A", "1/1/1985"));
        bst.addPatientRecord(new PatientRecord("B", "1/1/1943"));
        bst.addPatientRecord(new PatientRecord("C", "1/1/1998"));
        bst.addPatientRecord(new PatientRecord("D", "1/1/1972"));
        bst.addPatientRecord(new PatientRecord("E", "1/1/2019"));
        bst.addPatientRecord(new PatientRecord("F", "1/1/2003"));
        bst.addPatientRecord(new PatientRecord("G", "1/1/1990"));
        if (bst.height() != 4) {
            System.out.println("height of tree with 7 node should have been 4 but it was not!");
            return false;
        }
        return true;
    }

    /**
     * Checks for the correctness of PatientRecordTree.height() method. This test must consider
     * several scenarios such as, (1) ensures that the height of an empty patient record tree is zero.
     * (2) ensures that the height of a tree which consists of only one node is 1. (3) ensures that
     * the height of a PatientRecordTree with the following structure for instance, is 4.
     *       (*)
     *     /    \
     *  (*)      (*)
     *    \     /  \
     *    (*) (*)  (*)
     *             /
     *           (*)
     * 
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testHeight() {
        PatientRecordTree bst = new PatientRecordTree();
        boolean pass1 = testHeight1(bst);
        boolean pass2 = testHeight2(bst);
        boolean pass3 = testHeight3(bst);
        if (pass1 && pass2 && pass3) {
            return true;
        }
        System.out.println("One of your test cases failed!");
        return false;
    }

    // END height testing scenarios

    // START youngest patient scenarios

    /**
     * checks return value on empty tree
     * @param bst
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testGetRecordOfYoungestPatient1(PatientRecordTree bst) {
        if (bst.getRecordOfYoungestPatient() != null) {
            System.out.println(
                "youngest patient should have returned null for an empty tree but it did not!");
            return false;
        }
        return true;
    }

    /**
     * checks return value on tree with only left children.
     * @param bst
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testGetRecordOfYoungestPatient2(PatientRecordTree bst) {
        bst.addPatientRecord(new PatientRecord("A", "1/1/1985"));
        bst.addPatientRecord(new PatientRecord("B", "1/1/1943"));
        bst.addPatientRecord(new PatientRecord("C", "1/1/1935"));
        if (!bst.getRecordOfYoungestPatient().getStringDateOfBirth().equals("1/1/1985")) {
            System.out.println("method did not return the youngest patient!");
            return false;
        }
        return true;
    }

    /**
     * checks return value on tree with multiple levels and children
     * @param bst
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testGetRecordOfYoungestPatient3(PatientRecordTree bst) {
        bst.addPatientRecord(new PatientRecord("D", "1/1/2019"));
        bst.addPatientRecord(new PatientRecord("E", "1/1/1972"));
        bst.addPatientRecord(new PatientRecord("F", "1/1/2018"));
        if (!bst.getRecordOfYoungestPatient().getStringDateOfBirth().equals("1/1/2019")) {
            System.out.println("method did not return the youngest patient!");
            return false;
        }
        return true;
    }

    /**
     * Checks for the correctness of PatientRecordTree.getRecordOfYoungestPatient() method.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testGetRecordOfYoungestPatient() {
        PatientRecordTree bst = new PatientRecordTree();
        boolean pass1 = testGetRecordOfYoungestPatient1(bst);
        boolean pass2 = testGetRecordOfYoungestPatient2(bst);
        boolean pass3 = testGetRecordOfYoungestPatient3(bst);
        if (pass1 && pass2 && pass3) {
            return true;
        }
        System.out.println("One of your test cases failed!");
        return false;
    }

    // END youngest patient scenarios

    // START oldest patient scenarios

    /**
     * checks return value on empty tree
     * @param bst
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testGetRecordOfOldestPatient1(PatientRecordTree bst) {
        if (bst.getRecordOfOldestPatient() != null) {
            System.out.println(
                "oldest patient should have returned null for an empty tree but it did not!");
            return false;
        }
        return true;
    }

    /**
     * checks return value on tree with only right children.
     * @param bst
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testGetRecordOfOldestPatient2(PatientRecordTree bst) {
        bst.addPatientRecord(new PatientRecord("A", "1/1/1985"));
        bst.addPatientRecord(new PatientRecord("B", "1/1/1998"));
        bst.addPatientRecord(new PatientRecord("C", "1/1/2019"));
        if (!bst.getRecordOfOldestPatient().getStringDateOfBirth().equals("1/1/1985")) {
            System.out.println("method did not return the oldest patient!");
            return false;
        }
        return true;
    }

    /**
     * checks return value on tree with multiple levels and children
     * @param bst
     * @return true indicating correct functionality and false otherwise. 
     */
    public static boolean testGetRecordOfOldestPatient3(PatientRecordTree bst) {
        bst.addPatientRecord(new PatientRecord("D", "1/1/1943"));
        bst.addPatientRecord(new PatientRecord("E", "1/1/1972"));
        bst.addPatientRecord(new PatientRecord("F", "1/1/1935"));
        bst.addPatientRecord(new PatientRecord("G", "1/1/1967"));
        if (!bst.getRecordOfOldestPatient().getStringDateOfBirth().equals("1/1/1935")) {
            System.out.println("method did not return the oldest patient!");
            return false;
        }
        return true;
    }
    
    /**
     * Checks for the correctness of PatientRecordTree.getRecordOfOldestPatient() method.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testGetRecordOfOldestPatient() {
        PatientRecordTree bst = new PatientRecordTree();
        boolean pass1 = testGetRecordOfOldestPatient1(bst);
        boolean pass2 = testGetRecordOfOldestPatient2(bst);
        boolean pass3 = testGetRecordOfOldestPatient3(bst);
        if (pass1 && pass2 && pass3) {
            return true;
        }
        System.out.println("One of your test cases failed!");
        return false;
    }

    // END oldest patient scenarios

    /**
     * Calls the test methods
     * 
     * @param args input arguments if any
     */
    public static void main(String[] args) {
        System.out.println("testing add, toString, and size methods... Result: "
            + testAddPatientRecordToStringSize());
        System.out.println(
            "testing add and lookup methods... Result: " + testAddPatientRecordAndLookup());
        System.out.println("testing height method... Result : " + testHeight());
        System.out.println(
            "testing youngest patient method... Result: " + testGetRecordOfYoungestPatient());
        System.out
            .println("testing oldest patient method... Result: " + testGetRecordOfOldestPatient());
    }

}
