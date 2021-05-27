import DataTable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App() {
	return (
		<div>
			<>
				<NavBar />
				<div className="container-fluid">
					<h1>Olá Mundo</h1>
					<DataTable />
				</div>
				<Footer />
			</>
		</div>
	);
}

export default App;