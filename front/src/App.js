import { Container, Nav, Navbar, Button} from "react-bootstrap";
import {
  HashRouter as Router,
  Switch,
  Route,
  Redirect,
  Link,
} from "react-router-dom";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import Login from "./components/authorization/Login";
import { logout } from "./service/auth";

function App () {

    const jwt = window.localStorage["jwt"];

    if (jwt) {
      return (
        <div>
          <Router>
            <Navbar expand bg="dark" variant="dark">
              <Navbar.Brand as={Link} to="/">
                Home
              </Navbar.Brand>
              <Nav className="mr-auto">
                <Nav.Link as={Link} to="/festivali">
                Festivali
                </Nav.Link>
              </Nav> 
              <Button onClick={() => logout()}>Logout</Button>            
            </Navbar>
            <Container style={{ paddingTop: "10px" }}>
              <Switch>
              <Route exact path="/" component={Home} />
                <Route
                  exact
                  path="/login"
                  render={() => <Redirect to="/" />}
                />
                <Route component={NotFound} />
              </Switch>
            </Container>
          </Router>
        </div>
      );
    } else {
      return (
        <Container>
          <Router>
            <Switch>
              <Route exact path="/login" component={Login} />
              <Route render={() => <Redirect to="/login" />} />
            </Switch>
          </Router>
        </Container>
      );
    }
  }

  export default App;