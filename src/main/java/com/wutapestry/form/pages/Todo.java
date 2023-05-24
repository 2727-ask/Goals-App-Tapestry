// package com.wutapestry.form.pages;
// import java.util.ArrayList;
// import java.util.List;

// import org.apache.tapestry5.annotations.Component;
// import org.apache.tapestry5.annotations.InjectComponent;
// import org.apache.tapestry5.annotations.OnEvent;
// import org.apache.tapestry5.annotations.Persist;
// import org.apache.tapestry5.annotations.Property;
// import org.apache.tapestry5.annotations.SetupRender;
// import org.apache.tapestry5.corelib.components.Hidden;
// import org.apache.tapestry5.corelib.components.TextField;
// import org.apache.tapestry5.corelib.components.Form;



// public class Todo {

   



//     @Property
//     private List<String> tasks;

//     @Property
//     private String task;

//     @Persist
//     @Property
//     private String myid;

//     @InjectComponent
//     private Form doneForm;


    

//     @Inject
//     private ComponentResources resources;

//     Object onSuccessFromDoneForm() {
//         System.out.println("Task Id is");
//         System.out.println(this.myid);
//         return Todo.class;
//     }

//     void setupRender() {
//         tasks = new ArrayList<>();
//         tasks.add("A");
//         tasks.add("B");
//         tasks.add("C");
//     }

//     // void markTaskAsDone(Task task) {
//     //     task.setDone(true);
//     // }

    
// }