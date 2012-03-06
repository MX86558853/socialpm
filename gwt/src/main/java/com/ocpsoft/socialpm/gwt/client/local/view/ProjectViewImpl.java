package com.ocpsoft.socialpm.gwt.client.local.view;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.google.gwt.user.client.ui.Label;
import com.ocpsoft.socialpm.gwt.client.local.view.component.HeroPanel;
import com.ocpsoft.socialpm.gwt.client.local.view.component.ListItem;
import com.ocpsoft.socialpm.gwt.client.local.view.component.UnorderedList;
import com.ocpsoft.socialpm.model.project.Project;
import com.ocpsoft.socialpm.model.user.Profile;

@ApplicationScoped
public class ProjectViewImpl extends FixedLayoutView implements ProjectView
{
   HeroPanel greeting = new HeroPanel();
   private final UnorderedList projectList = new UnorderedList();

   private final Label email = new Label();

   @Override
   public void setup()
   {
      System.out.println("Construct ViewProfileView");
      content.add(greeting);
      greeting.getUnder().add(email);
      content.add(projectList);
   }

   @Override
   public void setProfile(final Profile profile)
   {
      greeting.setHeading("This is " + profile.getUsername() + "!");
      greeting.setContent(profile.getBio());
      email.setText(profile.getEmail());
   }

   /*
    * Getters & Setters
    */
   @Override
   public HeroPanel getGreeting()
   {
      return greeting;
   }

   @Override
   public void setProjects(List<Project> projects)
   {
      for (Project project : projects) {
         projectList.add(new ListItem(project.getName()));
      }
   }
}