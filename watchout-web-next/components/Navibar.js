import Link from 'next/link'

const Navibar = () => (
    <div>
        <ul>
            <li><Link href="/watch"><a>Watch</a></Link></li>
            <li><Link href="/login"><a>Login</a></Link></li>
        </ul>

        <style jsx>{`
            ul {
                background: #8977ad;
                color: #fff;
                list-style: none;
                display: flex;
            }

            ul li {
                font-size: 18px;
                margin-right: 20px;
            }

            ul li a {
                color: #fff;
                text-decoration: none;
            }
        `}</style>
    </div>
)

export default Navibar