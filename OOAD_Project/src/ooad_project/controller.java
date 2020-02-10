/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;

import java.util.ArrayList;
/**
 *
 * @author Acer
 */
public class controller {
    dbConnectivity myDb;
    public controller()
    {
        myDb=new dbConnectivity();
    }
    public ArrayList<String> getProjectBeneficiaries(String p)
    {
        return myDb.getProjectBeneficiaries(p);
    }
    public ArrayList<String> getProjectDonors(String p)
    {
        return myDb.getProjectDonors(p);
    }
    public int replacevolunteer(String name,String name2,String project)
    {
        return myDb.replacevolunteer(name, name2,project);
    }
    public ArrayList<String> getreplacemanagernames (String n)
    {
        return myDb.getreplacemanagernames(n);
    }
    public String getmanagername (String n)
    {
        return myDb.getmanagername(n);
    }
    public int replacemanager(String name,String project)
    {
        return myDb.replacemanager(name,project);
    }
    public ArrayList <String> getcurrentvolunteers (String n)
    {
        return myDb.getcurrentvolunteers(n);
    }
    public ArrayList <String> getremainingvolunteers (String n)
    {
        return myDb.getremainingvolunteers(n);
    }
    public int allocateTeam(String name)
    {
        return 0;
    }
    public int[] checkbalance(String project)
    {
       return myDb.checkbalance(project);
    }
     public int addissuedonation (String project , String beneficiary , int amount , int weight)
    {
       return myDb.addissuedonation(project, beneficiary, amount, weight);
    }
    public int removevolunteer(String name,String project)
    {
        return myDb.removevolunteer(name, project);
    }     
    public ArrayList<String> getDonorsList()
    { 
        return myDb.getDonorsList();
    }
    public int selectbeneficiary(String project,String beneficiary)
    {
        return myDb.selectbeneficiary(project, beneficiary);
    }
     public int selectteam(String project , String volunteer)
    {
        return myDb.selectteam(project, volunteer);
    }
     public ArrayList<String> getvolunteerNames()
    {
        return myDb.getvolunteerNames();
    }
    public Beneficiary getBeneficiaryFull(String cnic)
    {
        return myDb.getBeneficiaryFull(cnic);
    }
    public ArrayList<String> getprojectbeneficiaryname (String p)
    {
        return myDb.getprojectbeneficiaryname(p);
    }
    public ArrayList<String> getBeneficiaries()
    {
        return myDb.getBeneficiaries();
    }
    public int addDonation(Donation d)
    {
        return myDb.addDonation(d);
    }
    public ArrayList<String> getDonorProjects(String n)
    {
       return myDb.getDonorProjects(n);
    }
    public String getname (String cnic)
    {
       return myDb.getname(cnic);
    }
    public String getbeneficiaryname (String cnic)
    {
       return myDb.getbeneficiaryname(cnic);
    }
    public Donor getDonorFull(String cnic)
    {
       return myDb.getDonorFull(cnic);
    }
    public int getdonorprojectweight(String n,String p)
    {
       return myDb.getdonorprojectweight(n, p);
    }
    public int getdonorprojectamount(String n, String p)
    {
       return myDb.getdonorprojectamount(n, p);
    }
    public int getbeneficiaryprojectweight(String n,String p)
    {
       return myDb.getbeneficiaryprojectweight(n, p);
    }
    public int getbeneficiaryprojectamount(String n,String p)
    {
       return myDb.getbeneficiaryprojectamount(n, p);
    }
    public ArrayList<String> getProjectNames()
    {
       return(myDb.getProjectNames());         
    }
    public int addProject(Project p)
    {
       return myDb.addProject(p);
    }
    public int checkPName(String N)
    {
       return myDb.checkname(N);
    }
    public Project getProject(String n)
    {
       return myDb.getProject(n); 
    }
    public int addDonor(Donor d)
    {
       return myDb.addDonor(d);
    }
    public int addBeneficiary(Beneficiary b)
    {
       return myDb.addBeneficiary(b);
    }
    public Volunteer getManager(String name)
    {
       Volunteer v = myDb.getManager(name);
       return v;
    }
    public int addVolunteer(Volunteer v)
    {
       return myDb.addVolunteer(v);
    }
    public ArrayList getManagerNames()
    {
       return myDb.getManagerNames();
    }
    public int checkMName(String MN) 
    {
       return myDb.checkMName(MN);  
    }
    public Project getProjectByMN(String MN)
    {
       return myDb.getProjectByMN(MN);
    }
}
