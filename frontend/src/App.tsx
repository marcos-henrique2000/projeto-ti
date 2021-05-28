import ColumnChart from "components/ColumnChart";
import ColumnChartTotal from "components/ColumnChartTotal";
import DataTable from "components/DataTable";
import DonutChart from "components/DonutChart";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App() {
	return (
		<div>
			<>
				<NavBar />
				<div className="container-fluid">

					<h1 style={{ textAlign: 'center' }}>Dashboard de Suporte</h1>
					<div className="row px-3">
						<div className="col-sm-4">
							<h5 className="text-center text-secondary">Atendimentos Mês</h5>
							<ColumnChart />
						</div>

						<div className="col-sm-4">
							<h5 className="text-center text-secondary">Total Atendimentos Funcionário</h5>
							<ColumnChartTotal />
						</div>

						<div className="col-sm-4">
							<h5 className="text-center text-secondary">Atendimentos por Nivel</h5>
							<DonutChart />
						</div>
					</div>
					<DataTable />
				</div>
				{/*  <Footer /> */}
			</>
		</div>
	);
}

export default App;