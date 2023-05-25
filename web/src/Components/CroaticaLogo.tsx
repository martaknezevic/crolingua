import styles from "./CroaticaLogo.module.css"

type CroaticaLogoProps = {
    style?: React.CSSProperties
};

function CroaticaLogo(props: CroaticaLogoProps) {
    return (
        <p className={styles.logo} style={props.style}>
            CROATICA
        </p>
    )
}

export default CroaticaLogo
