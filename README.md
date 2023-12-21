# Task Manager

A basic terminal-based Task Manager application leveraging Java and the `java.time` class.

## Overview

This project is a simple Task Manager running entirely on the terminal, designed to handle tasks along with their details and deadlines.

### Features

- **Task Creation:** Allows users to input task names and optionally provide task details.
- **Time Scheduling:** Requests the time when the task needs to be done in 'YYYY-MM-DD HH:mm' (24hr) format.
- **Deadline Management:** Optionally captures task deadlines.
- **Reminder System (In Development):** Future functionality to set reminders at specific intervals.
- **Task Execution Monitoring:** Allows users to start and complete tasks, capturing start and end times.
- **Task Details Retrieval:** Retrieves and displays task details including name, details (if given), and deadlines (if provided).
- **Time Tracking:** Records the end time of task completion and calculates the time taken in minutes.

## How to Use

1. **Adding a Task:**
    - Run the application.
    - Enter the task name.
    - Optionally, provide task details.
    - Input the time the task needs to be done (format: YYYY-MM-DD HH:mm).
    - Optionally, set a task deadline.
    - (Future) Set reminders if desired.

2. **Task Execution:**
    - When it's time to start the task, type 'started' in the terminal.
    - Upon task completion, type 'done' in the same terminal.

3. **Retrieving Task Details:**
    - The application will display task details upon task completion.
    - Details include task name, optional details, and deadline (if provided).
    - End time of the task and the duration taken will be shown.

## Future Enhancements

- **Reminder System:** Implement a feature to provide reminders at specified intervals.
- **User Interface:** Develop a user-friendly interface beyond the terminal.
- **Extended Functionality:** Explore additional features to enhance task management.

## Technologies Used

- Java
- `java.time` class

## Contribution

Contributions are welcome! Feel free to fork the project, make improvements, and submit a pull request.

## License

This project is licensed under the [MIT License].
