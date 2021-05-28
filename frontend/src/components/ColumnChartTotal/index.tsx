import Chart from 'react-apexcharts'

const ColumnChartTotal = () => {

    const options = {
        plotOptions: {
            bar: {
                columnWidth: '15%',
                endingShape: 'rounded'
            }
        },
        dataLabels: {
            enabled: true
        },
        legend: {
            show: true
        },
    };

    const mockData = {
        labels: {
            categories: ['Geovani', 'Daniel', 'Felipe']
        },
        series: [
            {
                data: [15, 18, 12]
            },
        ]
    }

    return (
        <Chart options={{ ...options, xaxis: mockData.labels }}
            series={mockData.series}
            type='bar'
            height="240"
        />
    )

}

export default ColumnChartTotal;