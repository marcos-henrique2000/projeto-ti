import Chart from 'react-apexcharts'

const DonutChart = () => {

    const mockData = {
        series: [58, 21],
        labels: ['Nivel 1', 'Nivel 2']
    }

    const options = {
        legend:{
            show: true
        }
    }

    return (
        <Chart options={{...options, labels: mockData.labels }}
        series={mockData.series}
        type="donut"
        height="240"
        />
    );
}

export default DonutChart;