import { FormEvent, useState } from "react"
import styles from "./Login.module.css"
import axios from "axios"
import { useAtom, atom } from 'jotai'
import { useNavigate } from "react-router-dom"

function Login() {
    const navigate = useNavigate();
    const [_, setToken] = useAtom(atom(""))
    const [username, setUsername] = useState<string>("")
    const [password, setPassword] = useState<string>("")
    const [error, setError] = useState<string | null>(null)

    const login = (e: FormEvent<HTMLButtonElement>) => {
        e.preventDefault();
        axios.post("/auth/login", {
            username: username,
            password: password
        }).then(res => {
            setToken(res.data.token)
            navigate("/tutorials")
        })
            .catch(err => setError(err.response.data.error!))
    }

    return (
        <div className={styles.loginpage}>
            <div className={styles.exit_button}></div>
            <div className={styles.login_container}>
                <h3 className={styles.login_form_title}>
                    Log in
                </h3>
                <form action="" className={styles.login_form}>
                    <input type="text" placeholder="Username" className={styles.login_input_field} onChange={(event: React.ChangeEvent<HTMLInputElement>) => setUsername(event.target.value)} />
                    <input type="password" placeholder="Password" className={styles.login_input_field} onChange={(event: React.ChangeEvent<HTMLInputElement>) => setPassword(event.target.value)} />
                    <button onClick={login}>Log in</button>
                    {error && <p>{error}</p>}
                </form>
            </div>
        </div>
    )
}

export default Login