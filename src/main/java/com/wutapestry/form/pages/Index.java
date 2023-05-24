package com.wutapestry.form.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.HttpError;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.internal.SelectModelImpl;
import org.apache.tapestry5.corelib.components.Hidden;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;

import com.wutapestry.form.models.TaskModel;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Start page of application app.
 */
public class Index {

    private static final Logger logger = LogManager.getLogger(Index.class);

    // ----- Form Starts -------//
    @InjectComponent
    private Form todo;

    @Property
    private String title;

    @Property
    private String description;

    @Property
    private String prioritySelect;

    @Property
    private String selectedPriority;
    // ----- Form Ends -------//


    // ------ Mark as Done Form Starts ------//

    

    @Property
    private String taskid = "id";

    




    // ------ Mark as Done Form Ends ------//

    @Inject
    private AlertManager alertManager;

    @Persist
    @Property
    private ArrayList<TaskModel> todoList;

    @Property
    private String app_title = "Goals";

    @Property
    private String app_todo = "Pending";

    @Property
    private String app_done = "Done";

    @Property
    private TaskModel dueTask;

    @Persist
    @Property
    private ArrayList<String> priorityList;


    @Persist
    @Property
    private ArrayList<String> doneList;



    

    // Todo Form Operations //

    void onActivate() {
        if (todoList == null) {
            todoList = new ArrayList<>();
        }
    }

    @OnEvent(value = "valuechanged", component = "prioritySelect")
    public void onCountrySelectChange() {
        
    }


    // Object onSuccessFromDoneForm() {
    //     System.out.println("Task Id is");
    //     System.out.println(this.taskid);
    //     return Index.class;
    // }

    Object onSuccessFromTodo() {
       
        TaskModel task = new TaskModel();
        System.out.println(this.todo);
        String color;

        

        if(this.selectedPriority.equals("High")){
            color = "#FF3131";
        }else if(this.selectedPriority.equals("Medium")){
            color = "#faed27";
        }else {
            color = "black";
        }

        task.setTitle(this.title);
        task.setDescription(this.description);
        task.setColor(color);
        task.setPriority(this.selectedPriority);

        // System.out.println(task.getTitle());
        // System.out.println(task.getDescription());


        try {
            this.todoList.add(0,task);
        } catch (Exception e) {
            System.out.println("Error Adding Task to List  " + e);
        }

        for (TaskModel mytask : todoList) {
            System.out.println(mytask.getTitle());
            System.out.println(mytask.getDescription());
            System.out.println(mytask.getDateCreated());
            System.out.println(mytask.getDateCompleted());
            System.out.println(mytask.getStatus());
            System.out.println(mytask.getColor());
            System.out.println(mytask.getPriority());
        }


        alertManager.success("Task Created Successfully!!");
        return Index.class;
    }

    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;

    @Property
    @Inject
    @Symbol(SymbolConstants.TAPESTRY_VERSION)
    private String tapestryVersion;

    @InjectPage
    private About about;

    @Inject
    private Block block;

    // Handle call with an unwanted context
    Object onActivate(EventContext eventContext) {
        return eventContext.getCount() > 0 ? new HttpError(404, "Resource not found") : null;
    }

    public void onDeleteTask(String taskId) {
         System.out.println("My Task Id is " + taskId);
    }

    // Object onActionFromLearnMoreLearnMore()
    // {
    // about.setLearn("LearnMore");

    // return about;
    // }

    @Log
    void onComplete() {
        logger.info("Complete call on Index page");
    }

    @Log
    void onAjax() {
        logger.info("Ajax call on Index page");

        ajaxResponseRenderer.addRender("middlezone", block);
    }

    public ZonedDateTime getCurrentTime() {
        return ZonedDateTime.now();
    }
}
