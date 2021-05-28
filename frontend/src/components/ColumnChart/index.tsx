import Chart from 'react-apexcharts'

const ColumnChart = () => {

    const options = {
        
        plotOptions: {
            bar:{
                horizontal: false,
                columnWidth: '60%',
                endingShape: 'rounded'
            },
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2,
            colors: ['transparent']
        },
    };

    const mockData = {
        labels: {
            categories: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai']
        },
        series: [
            {
                name: "Geovani",
                data: [9, 15, 7, 10, 11]
            },
            {
                name: "Daniel",
                data: [7, 12, 20, 25, 17]
            },
            {
                name: "Felipe",
                data: [8, 11, 17, 21, 16]
            }
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

export default ColumnChart;