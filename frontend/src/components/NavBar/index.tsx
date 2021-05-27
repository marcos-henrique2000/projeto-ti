import reactImg from 'assets/img/react.png';

const NavBar = () => {
    return (
        <>
            <header className="bd-header bg-dark py-1 d-flex align-items-stretch 
                                border-bottom border-dark px-md-5 mb-3">

                <div className="container-fluid d-flex align-items-center">
                    <img src={reactImg} alt="Dev in React" width="90" />
                    <h1 className="d-flex align-items-center fs-4 text-white mb-0 titleNavBar">
                        Analise e Monitoramento de Suporte ao Usuário
                    </h1>
                </div>
                <div>
                    <nav className="navbar navbar-dark bg-dark">
                        <div className="container-fluid">
                            <button className="navbar-toggler" type="button" 
                                    data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" 
                                    aria-controls="navbarToggleExternalContent" aria-expanded="false" 
                                    aria-label="Toggle navigation">

                                <span className="navbar-toggler-icon"></span>
                            </button>
                        </div>
                    </nav>
                </div>
            </header>
        </>
    );
}

export default NavBar;