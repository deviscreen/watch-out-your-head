import Head from 'next/head'
import Navibar from './Navibar'

const Layout = (props) => (
    <div>
        <Head>
            <title>Num6 Watch Out</title>
        </Head>
        <Navibar/>
        {props.children}
    </div>
)

export default Layout