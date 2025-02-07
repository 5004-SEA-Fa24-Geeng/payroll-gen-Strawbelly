# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for? 

    CSV is a file format which is used to store data with coma as the delimiter. In this program, the CSV files are used to store employee information, pay information, and payroll calculation results.


2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
    
    `List<Imployee>` supports Polymorphism, which means it can store different types of employees. If we want to change the employee type in the list, for example, changing to `SalaryEmployee`, we only need to change its implementation without modifying too much code. We declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>` because it's more general and flexible.
    

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?

    It's a has-a relationship because that object is simply an attribute of the first class, and there is no inheritance relationship between them.


4. Can you provide an example of a has-a relationship in your code (if one exists)?
    
    The `HourlyEmployee` Class has a has-a relationship with the Enumeration Class `EmoloyeeType`, because it references an Enumeration object `EmployeeType.HOURLY` as a field, representing the employee type.


5. Can you provide an example of an is-a relationship in your code (if one exists)?
    
    The `SalaryEmployee` Class has a is-a relationship with the abstract class `Employee`, because the `SalaryEmployee` Class inherits the `Employee` Class, and a salary employee is a type of employee.


6. What is the difference between an interface and an abstract class?
    
    An abstract class is a class, which means it can have attributes, constructors, and both concrete methods and abstract methods. However, an interface cannot have attributes or constructors. Also, an ordinary class can implement many interfaces, but can only inherit one abstract class.


7. What is the advantage of using an interface over an abstract class?
    
    The advantage of using an interface over an abstract class is its flexibility. A class can implement many interfaces, but it can only extend one abstract class. When we want to add more methods to an ordinary class, interfaces are a better choice.


8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 
    
    This code is invalid because `List`stores object, not the primitive data types. So we need to use the wrapper class `Integer` instead of `int`, which is a primitive data type. The correct code should be `List<Integer> numbers = new ArrayList<Integer>();`.


9. Which class/method is described as the "driver" for your application? 
    
    The `main` method in the `PayrollGenerator` Class is the driver of the application. It's the main entry point of the whole program.


10. How do you create a temporary folder for JUnit Testing?
   
    We can use the `@TempDir` annotation to create a temporary folder for Junit Testing. This annotation will create a temporary folder for each test method and automatically delete the temporary folder after the test execution.   

## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

* To ensure paying employees more fairly, one important thing is to add additional data points in the employee file. Considering gender and race/ethnicity wage discrimination is widespread[^1] , we should include additional employee information such as gender, race/ethnicity, and job level to the employee file. These data could help identify wage discrepancies and allow us to remedy them once found.
When calculating the gross pay, it’s crucial to use the same calculation logic for every employee in the same job level. Gender or race/ethnicity should not influence the base salary calculation, otherwise, it may lead to unfair wage disparities.

* Another important thing is to include pretax benefits in the calculation[^2] , such as health insurance and relocation assistance. Different employees could have different pretax benefits, which could lead to huge disparities in total wages. Therefore, after calculating the basic pay, we should add the total prefix benefits to get the full wages. And we should always ensure that employees in the same job level receive the same types of pretax benefits.

[^1]: https://hbr.org/2022/12/what-it-takes-to-be-a-fair-pay-workplace. Accessed: 2025-02-07.

[^2]: https://www.indeed.com/hire/c/info/most-commonly-offered-employee-benefits?gad_source=1&gclid=Cj0KCQiA-5a9BhCBARIsACwMkJ60YIRqc0D7Ou2Wl74pWFRZhD5gqxut4vbe3ReFBRDqbAdemTMYXe8aArz8EALw_wcB&hl=en&aceid=&gclsrc=aw.ds. Accessed: 2025-02-07.