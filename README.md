# Java-Citizen-Vaccination-Registry
## Overview
This project is a hypothetical implementation of an application to manage a Citizen Vaccination Registry, created in response to a surge in COVID-19 cases. The aim is to assist the Ministry of Health in developing a simple application to monitor citizens and their vaccination statuses.

## Requirements
The following requirements were provided as part of the assignment:

All data must be stored in a single collection.
Each citizen is identified by a unique civil ID number (national number), name, and at least two additional attributes.
Vaccination details for each citizen, including manufacturer, date, location, and health professional information, must be recorded.
Health professionals have a unique civil ID number, name, and experience in years.
Frequent operations include adding a new citizen, adding a new dose to a citizen, retrieving the number of fully vaccinated persons, and saving all data to a text file after sorting by Civil ID.
## Implementation
Object-Oriented Programming style is followed.
Good programming practices, including comments, are adhered to.
Constructors, setters, getters, toString() methods, and other necessary methods are implemented.
Error handling is implemented for operations that could violate object states.
Equality of objects is checked using the equals() method.
A class is created to manage the application with a collection for storing all citizens.
Static methods are included for frequently occurring operations, providing user-friendly messages.
## Testing
A testing class is designed and implemented to:
Add at least 7 citizens to the collection.
Add 1, 2, and 3 doses to different citizens, keeping some unvaccinated.
Attempt to violate object states, demonstrating that the code prevents violations.
Verify the functionality of other frequently occurring operations.
Save the entire dataset into a text file, automatically placed in the Java project folder.
