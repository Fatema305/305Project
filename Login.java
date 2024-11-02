import java.util.HashMap;
import java.util.Map;

// Data Layer
// The User class represents a user with a username and password.
class User {
    private String username;
    private String password;

    // Constructor initializes user with a username and password.
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }
}

// UserRepository manages user data in a simple in-memory map.
// For storing and retrieving user information.
class UserRepository {
    private Map<String, User> users = new HashMap<>();

    // Adds a user to the repository
    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    // Retrieves a user by their username; returns null if not found.
    public User findByUsername(String username) {
        return users.get(username);
    }
}

// Business Layer
// AuthenticationService represents the business layer for user login operations.
// for user authentication.
class AuthenticationService {
    private UserRepository userRepository;

    // Constructor initializes with a UserRepository
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Verifies the user's credentials by checking if the username and password are valid.
    // Returns true if the user is authenticated; otherwise, returns false.
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        // Check if user exists and password matches
        return user != null && user.getPassword().equals(password);
    }
}

// Presentation Layer
// LoginController serves as the presentation layer for handling user interaction
// for login operations. It interacts with the AuthenticationService to manage
// user login attempts.
class LoginController {
    private AuthenticationService authService;

    // Constructor initializes the controller with an AuthenticationService
    public LoginController(AuthenticationService authService) {
        this.authService = authService;
    }

    // Handles a login attempt by checking the provided credentials with the AuthenticationService.
    // Outputs the result of the authentication to the console.
    public void login(String username, String password) {
        boolean isAuthenticated = authService.authenticate(username, password);

        // Display the result of the login attempt to the console
        if (isAuthenticated) {
            System.out.println("Login successful! Access granted.");
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }
}