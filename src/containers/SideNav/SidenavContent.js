import React, { Component } from 'react';
import { NavLink, withRouter } from 'react-router-dom';

import IntlMessages from 'util/IntlMessages';
import CustomScrollbars from 'util/CustomScrollbars';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCalendarAlt, faUserEdit, faRocket} from '@fortawesome/free-solid-svg-icons';
class SidenavContent extends Component {
    componentDidMount() {
        const { history } = this.props;
        const that = this;
        const pathname = `#${history.location.pathname}`;// get current path

        const subMenuLi = document.querySelectorAll('.sub-menu > li');
        for (let i = 0; i < subMenuLi.length; i++) {
            subMenuLi[i].onclick = function (event) {
                event.stopPropagation();
            }
        }

        const menuLi = document.getElementsByClassName('menu');
        for (let i = 0; i < menuLi.length; i++) {
            menuLi[i].onclick = function (event) {
                for (let j = 0; j < menuLi.length; j++) {
                    const parentLi = that.closest(this, 'li');
                    if (menuLi[j] !== this && (parentLi === null || !parentLi.classList.contains('open'))) {
                        menuLi[j].classList.remove('open')
                    }
                }
                this.classList.toggle('open');
                event.stopPropagation();
            }
        }

        const activeLi = document.querySelector('a[href="' + pathname + '"]');// select current a element
        try {
            const activeNav = this.closest(activeLi, 'ul'); // select closest ul
            if (activeNav.classList.contains('sub-menu')) {
                this.closest(activeNav, 'li').classList.add('open');
            } else {
                this.closest(activeLi, 'li').classList.add('open');
            }
        } catch (error) {

        }
    }

    closest(el, selector) {
        try {
            let matchesFn;
            // find vendor prefix
            ['matches', 'webkitMatchesSelector', 'mozMatchesSelector', 'msMatchesSelector', 'oMatchesSelector'].some(function (fn) {
                if (typeof document.body[fn] == 'function') {
                    matchesFn = fn;
                    return true;
                }
                return false;
            });

            let parent;

            // traverse parents
            while (el) {
                parent = el.parentElement;
                if (parent && parent[matchesFn](selector)) {
                    return parent;
                }
                el = parent;
            }
        } catch (error) {

        }

        return null;
    }

    render() {
        return (
            <CustomScrollbars className="scrollbar">
                <ul className="nav-menu">
                    <ul className="nav-menu">
                    <li className="menu no-arrow">
                            <NavLink to="/app/mural">
                                <i className="zmdi zmdi-hc-fw">
                                    <FontAwesomeIcon icon={faRocket} />
                                </i>
                                <span className="nav-text">
                                    Mural
                                </span>
                            </NavLink>
                        </li>
                        <li className="menu no-arrow">
                            <NavLink to="/app/eventos">
                                <i className="zmdi zmdi-hc-fw">
                                    <FontAwesomeIcon icon={faCalendarAlt} />
                                </i>
                                <span className="nav-text">
                                    Eventos
                                </span>
                            </NavLink>
                        </li>
                       
                        <li className="menu no-arrow">
                            <NavLink to="/app/cadastro">
                                <i className="zmdi zmdi-hc-fw">
                                    <FontAwesomeIcon icon={faUserEdit} />
                                </i>
                                <span className="nav-text">
                                    Cadastro
                                </span>
                            </NavLink>
                        </li>
                    </ul>

                </ul>
            </CustomScrollbars>
        );
    }
}

export default withRouter(SidenavContent);
