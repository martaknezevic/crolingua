import styles from "./Home.module.css"
import { useNavigate } from "react-router-dom"
import CroaticaLogo from "../Components/CroaticaLogo"


function Home() {
    const navigate = useNavigate()

    return (
        <div className={styles.frontpage}>
           <button className={styles.login_button} onClick={() => navigate("/login")}>Log in</button>

            <div className={styles.frontpage_title_div}>
                <CroaticaLogo />
                <p className={styles.frontpage_title}>
                    Learn croatian language.
                </p>
            </div>
        </div>
    )
}

export default Home