import { Container, Nav, Navbar,} from "react-bootstrap";
import {
  HashRouter as Router,
  Switch,
  Route,
  Redirect,
  Link,
} from "react-router-dom";
import Login from "./components/authorization/Login";

function App () {

    const jwt = window.localStorage["jwt"];

    if (jwt) {
      return (
        <div>
          <Router>
            <Navbar expand bg="dark" variant="dark">
              <Navbar.Brand as={Link} to="/">
                JWD
              </Navbar.Brand>
              <Nav className="mr-auto">
                <Nav.Link as={Link} to="/festivali">
                Festivali
                </Nav.Link>
              </Nav>             
            </Navbar>
            <Container style={{ paddingTop: "10px" }}>
              <Switch>
                <Route
                  exact
                  path="/login"
                  render={() => <Redirect to="/" />}
                />
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